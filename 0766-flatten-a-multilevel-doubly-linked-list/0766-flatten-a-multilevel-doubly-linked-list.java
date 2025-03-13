/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        Node ans = new Node(head.val);
        Node headChild = head.child;
        Node headNext = head.next;
        Node temp = ans;
        if(headChild != null) {
            temp.next = flatten(headChild);
            while(temp.next != null) {
                temp.next.prev = temp;
                temp = temp.next;
            }
        }
        if(headNext != null) {
            temp.next = flatten(headNext);
            if(temp.next != null) {
                temp.next.prev = temp;
            }
        }
        return ans;
    }
}