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
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(fast);
        return mergeList(firstHalf, secondHalf);
    }

    public ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode mergedList = head;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                mergedList.next = list1;
                list1 = list1.next;
            } else {
                mergedList.next = list2;
                list2 = list2.next;
            }
            mergedList = mergedList.next;
        }
        if(list1 != null) mergedList.next = list1;
        if(list2 != null) mergedList.next = list2;
        return head.next;
    }
}