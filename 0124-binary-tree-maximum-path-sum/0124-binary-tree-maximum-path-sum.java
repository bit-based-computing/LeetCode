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
    int ans = Integer.MIN_VALUE;

    public int pathSum(TreeNode root) {
         if(root == null) return 0;
        int left = pathSum(root.left);
        int right = pathSum(root.right);
        int total = left + right + root.val;
        int lroot = root.val + left;
        int rroot = root.val + right;
        ans = Math.max(ans, Math.max(root.val, Math.max(total, Math.max(lroot, rroot))));
        return Math.max(root.val ,Math.max(lroot, rroot));
    }

    public int maxPathSum(TreeNode root) {
       pathSum(root);
       return ans;
    }
}