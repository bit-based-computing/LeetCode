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
    TreeNode root = new TreeNode(-1);
    public TreeNode bstFromPreorder(int[] preorder) {
        for(int i = 0; i < preorder.length; i++) {
            buildTree(root, preorder[i]);
        }
        return root;
    }

   private void buildTree(TreeNode root, int x) {
        if(root.val == -1){
            root.val = x;
            return;
        } 
        if(x < root.val) {
            if(root.left == null) root.left = new TreeNode(-1);
            buildTree(root.left, x);
        } 
        else {
            if(root.right == null) root.right = new TreeNode(-1);
            buildTree(root.right, x);    
        }    
    }
}