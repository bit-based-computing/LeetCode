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
    Map<Integer, Integer> inmap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inmap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) return null;
        TreeNode node = new TreeNode(post[postEnd]);
        int rootIndex = inmap.get(post[postEnd]);
        int leftTreeSize = rootIndex - inStart;
        node.left = buildTree(in, inStart, rootIndex - 1, post, postStart, postStart + leftTreeSize - 1);
        node.right = buildTree(in, rootIndex + 1, inEnd, post, postStart + leftTreeSize, postEnd - 1);
        return node;
    }
}