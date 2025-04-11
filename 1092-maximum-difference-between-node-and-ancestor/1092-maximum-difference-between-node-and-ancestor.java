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
    int maxAns = 0;
    public void getMaxDiff(TreeNode root, int max, int min) {
        int minDiff = Math.abs(root.val - min);
        int maxDiff = Math.abs(root.val - max);
        maxAns = Math.max(maxAns, minDiff);
        maxAns = Math.max(maxAns, maxDiff);
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        if(root.left != null) getMaxDiff(root.left, max, min);
        if(root.right != null) getMaxDiff(root.right, max, min);
    }
    public int maxAncestorDiff(TreeNode root) {
        int max = root.val;
        int min = root.val;
        getMaxDiff(root,  max,  min);
        return maxAns;
    }
}