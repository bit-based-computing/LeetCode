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
    public boolean isPalindrome(ListNode head) {
        ListNode tempHead = head;
        ListNode temp = null;
        ListNode prev = null;

        while(tempHead != null) {
            temp = new ListNode(tempHead.val);
            tempHead = tempHead.next;
            temp.next = prev;
            prev = temp;
        }

        while(prev != null && head != null) {
            if(prev.val != head.val) return false;
            prev = prev.next;
            head = head.next;
        }

        return true;
    }
}