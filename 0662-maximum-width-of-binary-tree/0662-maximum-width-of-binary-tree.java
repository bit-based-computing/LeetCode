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

 class Pair {
    TreeNode node;
    int position;
    Pair(TreeNode node, int position) {
        this.node = node;
        this.position = position;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int ans = 1;
        q.add(new Pair(root, 1));
        while(!q.isEmpty()) {
            int size = q.size();
            int initial = -1;
            for(int i = 0; i < size; i++) {
                Pair pair = q.poll();
                if(initial == -1) {
                    initial = pair.position;
                } else if(pair.position - initial + 1 > ans) ans = pair.position - initial + 1;
                if(pair.node.left != null) {
                    int pos = ((pair.position - 1) * 2) + 1;
                    q.add(new Pair(pair.node.left, pos));
                }
                if(pair.node.right != null) {
                    int pos = ((pair.position - 1) * 2) + 2;
                    q.add(new Pair(pair.node.right, pos));
                }
            }
        }
        return ans;
    }
}