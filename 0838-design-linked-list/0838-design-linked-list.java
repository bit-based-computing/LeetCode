class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {

    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node temp = head;
        for(int i = 0; i < index; i++) temp = temp.next;
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val, head);
        head = node;
        if(size == 0) tail = head;
        size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;
        if(index == 0) addAtHead(val);
        else if(index == size) addAtTail(val);
        else {
            int count = 0;
            Node newNode = new Node(val);
            Node temp = head;
            for(int i = 0; i < index - 1; i++) temp = temp.next;
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        if(index == 0) {
            head = head.next;
            if(--size == 0) {
                tail = null;
            }
        } else {
            Node temp = head;
            for(int i = 0; i < index - 1; i++) temp = temp.next;
            if(temp.next == tail) tail = temp;
            temp.next = temp.next.next;
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */