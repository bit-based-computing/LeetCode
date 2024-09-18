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
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode before_cur = before;
        ListNode after_cur = after;
        while(head != null) {
            if(head.val < x) {
                before_cur.next = head;
                before_cur = before_cur.next;
            } else {
                after_cur.next = head;
                after_cur = after_cur.next;
            }
            head = head.next;
        }
        after_cur.next = null;
        before_cur.next = after.next;
        return before.next;
    }
}