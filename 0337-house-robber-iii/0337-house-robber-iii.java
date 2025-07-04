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
        Map<TreeNode, int[]> map = new HashMap<>();
        return maxAmount(0, root, map);
    }

    int maxAmount(int prevTaken, TreeNode root,  Map<TreeNode, int[]> map) {
            if(root ==  null) return 0;
            if(map.get(root) == null) map.put(root, new int[]{-1,-1});
            if(map.get(root)[prevTaken] != -1) return map.get(root)[prevTaken];
            int[] dp = map.get(root);
            if(prevTaken == 0) {
                dp[prevTaken] = Math.max(root.val + maxAmount(1, root.left, map) + maxAmount(1, root.right, map), 
                                maxAmount(0, root.left, map) + maxAmount(0, root.right, map));
            } else {
                dp[prevTaken] = maxAmount(0, root.left, map) + maxAmount(0, root.right, map);
            }
            return dp[prevTaken];
    }
}