/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = new TreeNode();
        generateTree(0, nums.length - 1, head, nums);
        return head;
    }

    private void generateTree(int l , int r, TreeNode head, int[] nums){
        if(l == r){
            head.val = nums[l];
        } else {
            int mid = (l+r)/2;
            head.val = nums[mid];
            if(mid - 1 >= l){
                head.left = new TreeNode();
                generateTree(l, mid - 1, head.left, nums);
            } 
            if(mid + 1 <= r){
                head.right = new TreeNode();
                generateTree(mid + 1, r, head.right, nums);
            } 
        }
    }


}