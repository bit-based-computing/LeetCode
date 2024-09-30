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
    int nc = 0;
    public int minCameraCover(TreeNode root) {
        return dfs(root) == -1 ? nc + 1: nc;
    }
    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == -1 || right == -1) {
            nc++;
            return 1;
        }
        if(left == 1 || right == 1) {
            return 0;
        }
        return -1;
    }
}