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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        return trimBST(null, root,  low,  high);
    }

    public TreeNode trimBST(TreeNode parent, TreeNode root, int low, int high) {
        if(root == null) return null;
        trimBST(root, root.left,  low,  high);
        trimBST(root, root.right, low, high);
        if(root.val < low || root.val > high) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if(right != null) {
                root.val = right.val;
                root.right = right.right;
                if(right.left == null) root.left = left;
                else {
                    TreeNode prev = right.left;
                    TreeNode temp = right.left;
                    while(temp != null) {
                        prev = temp;
                        temp = temp.left;
                    }
                    prev.left = left;
                    root.left = right.left;
                }
                
            } else if(left != null) {
                root.val = left.val;
                root.left = left.left;
                root.right = left.right;
            } else {
                if(parent != null) {
                    if(parent.left == root) parent.left = null;
                    else parent.right = null;
                }
                root = null;
            }
        }
        return root;        
    }
}