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
    int count = 0;
    public int goodNodes(TreeNode root) {
        int max = -10001;
        countGoodNode(root, max);
        return count;
    }
    private void countGoodNode(TreeNode root, int max){
        if(root == null) return;
        if(root.val >= max) count++;
        max = Math.max(max,root.val);
        countGoodNode(root.left, max);
        countGoodNode(root.right, max);
    }
}