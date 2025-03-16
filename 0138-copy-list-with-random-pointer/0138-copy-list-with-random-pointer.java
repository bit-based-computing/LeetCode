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
        Map<Node, Node> map = new HashMap<>();
        Node ans = new Node(0);
        Node temp = ans;
        while(head != null) {
            if(map.get(head) != null) {
                temp.next = map.get(head);
            } else {
                temp.next = new Node(head.val);
                map.put(head, temp.next);
            }
            if(head.random != null) {
                if(map.get(head.random) == null) {
                    temp.next.random = new Node(head.random.val);
                    map.put(head.random, temp.next.random);
                } else {
                    temp.next.random = map.get(head.random);
                }
            }
            head = head.next;
            temp = temp.next;
        }
        return ans.next;
    }
}