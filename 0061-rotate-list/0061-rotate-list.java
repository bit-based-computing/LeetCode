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
        if(head == null || head.next == null || k == 0) return head;
        ListNode temp = head;
        ListNode tail = null;
        int count = 0;
        while(temp != null) {
            count++;
            tail = temp;
            temp = temp.next;
        }
        k = k % count;
        count = count - k;
        tail.next = head;
        int i = 0;
        temp = head;
        while(temp != null) {
            i++;
            if(i == count) {
                head = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}