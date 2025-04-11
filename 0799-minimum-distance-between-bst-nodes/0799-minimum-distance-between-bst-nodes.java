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
    int ans = Integer.MAX_VALUE;
    int prev = -1;
    public void getDiff(TreeNode root) {
        if(root == null) return;
        getDiff(root.left);
        if(prev >= 0) {
            ans = Math.min(ans, Math.abs(root.val - prev));
        }
        prev = root.val;
        getDiff(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        getDiff(root);
        return ans;    
    }
}