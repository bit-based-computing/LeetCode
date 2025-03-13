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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode tempH = null;
        ListNode tempT = null;
        while(head != null) {
            if(head.val < x) {
                if(newHead == null) {
                    newHead = head;
                    tempH = newHead;
                } else {
                    tempH.next = head;
                    tempH = tempH.next;
                }
            } else {
                if(newTail == null) {
                    newTail = head;
                    tempT = newTail;
                } else {
                    tempT.next = head;
                    tempT = tempT.next;
                }
            }
            head = head.next;
        }
        if(tempT != null) tempT.next = null;
        if(newHead == null) {
            return newTail;
        }
        tempH.next = newTail;
        return newHead;
    }
}