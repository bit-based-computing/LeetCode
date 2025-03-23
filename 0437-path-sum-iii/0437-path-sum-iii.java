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
    public int pathSum(TreeNode root, int targetSum) {
        countPath(root, 0, targetSum, false);
        return count;
    }

    public void countPath(TreeNode root, long currentSum, long targetSum, boolean with) {
        if(root == null) return;
        if(currentSum + root.val == targetSum){
            count++;
        }
        if(with) {
            countPath(root.left, currentSum + root.val, targetSum, true);
            countPath(root.right, currentSum + root.val, targetSum, true);
        } else {
            countPath(root.left, currentSum + root.val, targetSum, true);
            countPath(root.right, currentSum + root.val, targetSum, true);
            countPath(root.left, 0, targetSum, false);
            countPath(root.right, 0, targetSum, false);
        }
        
    }
}