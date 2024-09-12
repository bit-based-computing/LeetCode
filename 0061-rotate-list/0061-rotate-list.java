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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode curh = head;
        int count = 0;
        while(curh != null) {
            count++;
            curh = curh.next;
        }
        k = k % count;
        if(k == 0) return head;
        int lastNode = count - k;
        curh = head;
        count = 0;
        ListNode newHead = null;

        while(curh != null) {
            count++;
            if(count == lastNode) {
                newHead = curh.next;
                curh.next = null;
                break;
            }
            curh = curh.next;
        }

        curh = newHead;
        while(curh.next != null) {
            curh = curh.next;
        }
        curh.next = head;

        return newHead;

    }
}