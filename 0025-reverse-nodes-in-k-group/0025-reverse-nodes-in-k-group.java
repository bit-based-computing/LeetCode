/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode temp = start.next;
        ListNode next = null;
        while(temp != end) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        temp.next = prev;
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        ListNode temp = head;
        int count = 0;
        ListNode ans = null;
        ListNode start = head;
        ListNode next = null;
        ListNode lastReversedNode = start;
        while(temp != null) {
              count++;
              if(count % k == 0) {
                next = temp.next;
                ListNode revNode = reverse(start, temp);
                if(ans == null) {
                    ans = revNode;
                } else {
                    lastReversedNode.next = revNode;
                }
                lastReversedNode = start;
                start = next;
                temp = next;
              } else {
                temp = temp.next;
              }
        }
        lastReversedNode.next = start;
        return ans;
    }
}