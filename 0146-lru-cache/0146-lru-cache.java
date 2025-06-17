public class Node{
    Node previouse;
    Node next;
    int key;
    int value;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int size = 0;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.previouse = head;
        size = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        removeNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.get(key) == null) {
            if(size > 0) {
                size--;
            } else {
                removeLeastUsedNode();
            }

            Node node = new Node(key, value);
            map.put(key, node);
            addNewNode(node);

        } else {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        }
    }

    void addNode(Node node) {
        Node previouse = node.previouse;
        Node next = node.next;

        previouse.next = next;
        next.previouse = previouse;

        node.previouse = tail.previouse;
        tail.previouse.next = node;

        node.next = tail;
        tail.previouse = node; 
    }

    void addNewNode(Node node) {
        node.previouse = tail.previouse;
        tail.previouse.next = node;
        node.next = tail;
        tail.previouse = node;
    }

    void removeNode(Node node) {
        node.previouse.next = node.next;
        node.next.previouse = node.previouse;
    }

    void removeLeastUsedNode() {
        Node node = head.next;
        head.next = head.next.next;
        head.next.previouse = head;
        map.remove(node.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */