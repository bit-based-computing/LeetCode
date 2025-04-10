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
    public boolean isMirror(TreeNode rootLeft, TreeNode rootRight) {
        if(rootLeft == null && rootRight == null) return true;
        if(rootLeft == null || rootRight == null) return false;
        if(rootLeft.val != rootRight.val) return false;
        if(!isMirror(rootLeft.left, rootRight.right)) return false;
        if(!isMirror(rootLeft.right, rootRight.left)) return false;
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
}