/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode curh = head;
        int count = k;
        while(curh != null && count > 0) {
            count--;
            curh = curh.next;
        }
        if(count > 0) return head;
        ListNode prev = reverseKGroup(curh, k);
        curh = head;
        for(int i = 0; i < k; i++) {
            ListNode next = curh.next;
            curh.next = prev;
            prev = curh;
            curh = next;
        }
        return prev;
    }
}