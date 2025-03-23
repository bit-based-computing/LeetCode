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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        return countPathSum(root, 0L, targetSum, prefixSumCount);
    }

    public int countPathSum(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if(node == null) return 0;
        int count = 0;
        currentSum += node.val;
        count = prefixSumCount.getOrDefault(currentSum - targetSum, 0);
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        count = count + countPathSum(node.left, currentSum, targetSum, prefixSumCount);
        count = count + countPathSum(node.right, currentSum, targetSum, prefixSumCount);
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) - 1);
        return count;
    }
}