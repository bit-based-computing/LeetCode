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
    int move = 0;
    public int distributeCoins(TreeNode root) {
        move = 0;
        dfs(root);
        return move;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;
        int leftExcess = dfs(root.left);
        int rightExcess = dfs(root.right);
        int excess = root.val + leftExcess + rightExcess - 1;
        move += Math.abs(leftExcess) + Math.abs(rightExcess);
        return excess;
    }
}