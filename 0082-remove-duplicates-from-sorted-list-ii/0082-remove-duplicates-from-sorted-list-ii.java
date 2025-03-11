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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next != null && head.val == head.next.val) {
            ListNode temp = head.next;
            while(temp != null && temp.val == head.val) {
                temp = temp.next;
            }
            head = deleteDuplicates(temp);
        }
        else if(head.next != null) head.next = deleteDuplicates(head.next);
        return head;
    }
}