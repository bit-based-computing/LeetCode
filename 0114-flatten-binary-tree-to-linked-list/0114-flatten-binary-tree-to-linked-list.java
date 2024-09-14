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

    // first set all left then process right

    TreeNode cuRoot = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        cuRoot = root;
        TreeNode right = root.right;
        if(root.left != null) {
            root.right = root.left;
            flatten(root.left);
            root.left = null;
        }
        if(right != null) {
            cuRoot.right = right;
            flatten(right);
        }
    }

    /* another way 
        // first set all right then process left
        TreeNode prev = null;
        public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    */
}