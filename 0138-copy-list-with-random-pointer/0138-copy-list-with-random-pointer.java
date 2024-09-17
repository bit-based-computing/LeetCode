/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
       if(head == null) return head;

       Node temp = head;

       while(temp != null) {
            Node n = new Node(temp.val);
            n.next = temp.next;
            temp.next = n;
            temp = temp.next.next;
       }

       temp = head;
       while(temp != null) {
           if(temp.random != null) {
                temp.next.random = temp.random.next;
           }
           temp = temp.next.next;
       }

       Node head2 = head.next;
       Node curr = head;
       Node copy = head.next;
       while(curr != null) {
            temp = curr.next.next;
            copy = curr.next;
            curr.next = temp;
            if(temp != null) copy.next = temp.next;
            curr = temp;
       }

       return head2;
    }
}