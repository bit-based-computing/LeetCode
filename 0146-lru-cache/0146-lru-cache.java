class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    HashMap<Integer, Node> map = new HashMap<>();

    private void addNode(Node newNode) {
        Node temp = head.next;

        head.next = newNode;
        newNode.prev = head;
        
        newNode.next = temp;
        temp.prev = newNode;
    }

    private void deleteNode(Node delNode) {
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
    }

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            int val = node.val;
            deleteNode(node);
            addNode(node);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            map.remove(key);
        } 
        if(map.size() == cap) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value));
        map.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */