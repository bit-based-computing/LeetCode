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
    Map<Long, Integer> map = new HashMap<>();
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0l, 1);
        totalPath(root, 0l, targetSum);
        return count;
    }

    public void totalPath(TreeNode root, Long currentSum, int targetSum){
        if(root == null) return;
        currentSum += root.val;
        count += map.getOrDefault(currentSum-targetSum, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        totalPath(root.left, currentSum, targetSum);
        totalPath(root.right, currentSum, targetSum);
        map.put(currentSum, map.get(currentSum) - 1);
    }


}