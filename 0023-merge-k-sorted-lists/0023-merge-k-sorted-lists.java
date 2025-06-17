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
        Queue<ListNode> queue = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        for(ListNode list: lists) {
            if(list != null) queue.offer(list);
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = node;
            if(node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }
}