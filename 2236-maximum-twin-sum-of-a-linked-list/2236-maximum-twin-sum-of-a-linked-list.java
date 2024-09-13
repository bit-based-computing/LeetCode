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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int l = 0;
        int r = list.size() - 1;
        int maxSum = 0;
        int sum = 0;
        while(l < r) {
            sum = (int)list.get(l) + (int)list.get(r);
            if(sum > maxSum) maxSum = sum;
            l++;
            r--;
        }
        return maxSum;
    }
}