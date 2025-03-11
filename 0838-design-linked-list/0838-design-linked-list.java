class Node {
    int val;
    Node next;

    public Node(){

    }
}

class MyLinkedList {

    Node head;
    Node tail;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        int count = 0;
        Node temp = head;
        while(temp != null) {
            if(count == index){
                return temp.val;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        Node currentHead = new Node();
        currentHead.val = val;
        currentHead.next = head;
        head = currentHead;
    }
    
    public void addAtTail(int val) {
        if(head == null) {
            addAtIndex(0, val);
            return;
        }
        Node node = new Node();
        node.val = val;
        Node temp = head;
        while(temp != null && temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0) {
            Node newNode = new Node();
            newNode.val = val;
            newNode.next = head;
            head = newNode;
            return;
        }
        int count = 0;
        Node temp = head;
        while(temp != null) {
            if(count == index - 1){
                Node newNode = new Node();
                newNode.val = val;
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
            count++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index == 0) {
            if(head != null) {
                head = head.next;
            }
            return;
        }
        int count = 0;
        Node temp = head;
        while(temp != null) {
            if(count == index - 1){
                if(temp.next != null) {
                    temp.next = temp.next.next;
                }
                break;
            }
            temp = temp.next;
            count++;
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