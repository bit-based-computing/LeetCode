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
        ListNode temp = head;
        ListNode fHead = new ListNode(-1);
        ListNode lastSmallNode = fHead;

        while (temp != null && temp.val < x) {
            lastSmallNode.next = temp;
            lastSmallNode = lastSmallNode.next;
            temp = temp.next;
        }
        if(temp == head) lastSmallNode.next = head;
        ListNode prev = lastSmallNode;
        while (temp != null) {
            ListNode ln = lastSmallNode.next;
            if(temp.val < x) {
                lastSmallNode.next = temp;
                prev.next = temp.next;
                temp.next = ln;
                temp = prev.next;
                lastSmallNode = lastSmallNode.next;
            } else {
                 prev = temp;
                 temp = temp.next;
            }
        } 
        return fHead.next;
    }
}