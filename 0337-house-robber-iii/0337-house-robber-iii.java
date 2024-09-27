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
    public int rob(TreeNode root) {
        int[] money = collectMoney(root);
        return Math.max(money[0], money[1]);
    }
    private int[]  collectMoney(TreeNode root) {
        if(root == null) return new int[] {0,0};
        int[] leftSum = collectMoney(root.left);
        int[] rightSum = collectMoney(root.right);
        int rob = root.val + leftSum[1] + rightSum[1];
        int notRob = Math.max(leftSum[1], leftSum[0]) + Math.max(rightSum[0], rightSum[1]);
        return new int[] {rob, notRob};
       
    }

}