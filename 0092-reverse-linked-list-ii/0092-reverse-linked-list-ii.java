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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;
        ListNode start = null;
        ListNode end = null;
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            if(count == left) {
                start = temp;
            }
            if(count == right) {
                end = temp.next;
                break;
            }
            temp = temp.next;
        }
        ListNode prev = start;
        ListNode next;
        temp = start.next;
        while(temp != null && temp != end) {
             next = temp.next;
             temp.next = prev;
             prev = temp;
             temp = next;
        }
        start.next = end;
        if(left == 1) return prev;
        temp = head;
        while(temp.next != start) {
            temp = temp.next;
        }
        temp.next = prev;
        return head;
    }
}