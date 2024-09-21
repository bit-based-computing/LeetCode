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
    public int longestZigZag(TreeNode root) {
        getAns(1, 1, root.right);
        getAns(1, 0, root.left);
        return ans;
    }

    private void getAns(int count, int side, TreeNode root) {
        if(root == null) return;
        ans = Math.max(ans, count);
        if(side == 1) {
            getAns(1, 1, root.right);
            getAns(count + 1, 0, root.left);
        } else {
            getAns(count + 1, 1, root.right);
            getAns(1, 0, root.left);
        }
    }
}