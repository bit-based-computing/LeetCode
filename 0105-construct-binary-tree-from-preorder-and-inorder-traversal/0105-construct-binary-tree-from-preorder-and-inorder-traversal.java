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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode node = new TreeNode(pre[preStart]);

        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(pre[preStart] == in[i]) {
                rootIndex = i;
                break;
            }
        }
        int leftTreeSize = rootIndex - inStart;
        node.left = buildTree(pre, preStart + 1, preStart + leftTreeSize, in, inStart, rootIndex - 1);
        node.right = buildTree(pre, preStart + leftTreeSize + 1, preEnd, in, rootIndex + 1, inEnd);
        return node;
    }
}