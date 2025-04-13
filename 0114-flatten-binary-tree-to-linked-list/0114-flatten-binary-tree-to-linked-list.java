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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        prev = root;
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.right = left;
        root.left = null;
        flatten(left);
        prev.right = right;
        flatten(right);
    }
}