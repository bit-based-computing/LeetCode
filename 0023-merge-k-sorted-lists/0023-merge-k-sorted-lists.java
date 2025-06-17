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
    public ListNode mergeKLists(ListNode[] lists) {
        
        List<Integer> list = new ArrayList<>();

        for(ListNode listNode: lists) {
            while(listNode != null) {
                list.add(listNode.val);
                listNode = listNode.next;
            }
        }

        Collections.sort(list);

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        for(Integer x: list) {
            ListNode node = new ListNode(x);
            current.next = node;
            current = node;
        }

        return dummy.next;
    }
}