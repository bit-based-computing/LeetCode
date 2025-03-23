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
    public TreeNode buildTree(int[] nums, int l, int r) {
        int max = -1;
        int maxIndex = 0;
        for(int i = l; i <= r; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        if(maxIndex - 1 >= l) root.left = buildTree(nums, l, maxIndex - 1);
        if(maxIndex + 1 <= r) root.right = buildTree(nums, maxIndex + 1, r);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
       return buildTree(nums, 0, nums.length - 1);
    }
}