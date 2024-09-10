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
    public int maxLevelSum(TreeNode root) {
        int cuMaxSum = root.val;
        int ans = 1;
        Queue<TreeNode> qtree = new LinkedList<>();
        qtree.add(root);
        int level = 1;
        while(!qtree.isEmpty()) {
            int size = qtree.size();
            int sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode tn = qtree.poll();
                sum += tn.val;
                if(tn.left != null) qtree.add(tn.left);
                if(tn.right != null) qtree.add(tn.right);
            }
            if(sum > cuMaxSum) {
                cuMaxSum = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}