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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head;
        if(list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode temp = head;
        ListNode next = null;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                next = list1.next;
                temp.next = list1;
                list1 = next;
            } else {
                next = list2.next;
                temp.next = list2;
                list2 = next;
            }
            temp = temp.next;
        }

        while(list1 != null) {
             next = list1.next;
             temp.next = list1;
             list1 = next;
             temp = temp.next;
        }

        while(list2 != null) {
             next = list2.next;
             temp.next = list2;
             list2 = next;
             temp = temp.next;
        }

        return head;

    }
}