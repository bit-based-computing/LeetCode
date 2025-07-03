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
    int ans = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        Map<Integer, int[]> map = new HashMap<>();
        return countLight(root, 1, 0, map);
    }

    public int countLight(TreeNode root, int node, int light, Map<Integer, int[]> map) {
        if (root == null)
            return 0;
        if(map.get(node) == null) map.put(node, new int[]{-1,-1,-1});
        int[] dp = map.get(node);
        if (dp[light] != -1)
            return dp[light];
        if (light == 0) {
            dp[light] = 1 + countLight(root.left, 2 * node, 1, map)
                    + countLight(root.right, (2 * node) + 1, 1, map);
            if (root.left != null && root.right != null) {
                dp[light] = Math.min(dp[light],
                        countLight(root.left, 2 * node, 2, map) + countLight(root.right, (2 * node) + 1, 0, map));
                dp[light] = Math.min(dp[light],
                        countLight(root.left, 2 * node, 0, map) + countLight(root.right, (2 * node) + 1, 2, map));
            } else if (root.left != null) {
                dp[light] = Math.min(dp[light], countLight(root.left, 2 * node, 2, map));
            } else if (root.right != null) {
                dp[light] = Math.min(dp[light], countLight(root.right, (2 * node) + 1, 2, map));
            }
        } else if (light == 1) {
            dp[light] = Math.min(
                    1 + countLight(root.left, 2 * node, 1, map) + countLight(root.right, (2 * node) + 1, 1, map),
                    countLight(root.left, 2 * node, 0, map) + countLight(root.right, (2 * node) + 1, 0, map));
        } else {
            dp[light] = 1 + countLight(root.left, 2 * node, 1, map)
                    + countLight(root.right, (2 * node) + 1, 1, map);
        }
        // System.out.println(node + " " + light + " " + dp[node][light]);
        return dp[light];
    }
}