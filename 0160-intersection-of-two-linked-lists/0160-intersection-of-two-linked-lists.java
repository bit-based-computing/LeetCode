/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        while(headA != null || headB != null) {
            if(headA != null) {
                if(map.get(headA) != null) return headA;
                map.put(headA,1);
                headA = headA.next;
            }

            if(headB != null) {
                if(map.get(headB) != null) return headB;
                map.put(headB,1);
                headB = headB.next;
            }
        }
        return null;
    }
}