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
    TreeNode ans = null;
    TreeNode prev = null;
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        removeNode(root, key);
        if(ans != null || root.val == key) return ans;
        return root;
    }
    private void removeNode(TreeNode root, int key) {
        if(root == null) return;
        if(root.val == key) {
            if(prev == null) {
                if(root.right != null) {
                    ans = root.right;
                    TreeNode temp = root.right.left;
                    prev = root.right;
                    while(temp != null) {
                        prev = temp;
                        temp = temp.left;
                    }
                    if(prev != null) {
                        prev.left = root.left;
                    }
                } else {
                    ans = root.left;
                }
            } else {
                if(prev.right == root) {
                   if(root.right != null) {
                     prev.right = root.right;
                     TreeNode rootLeft = root.left;
                     TreeNode temp = root.right.left;
                     prev = root.right;
                     while(temp != null) {
                        prev = temp;
                        temp = temp.left;
                     }
                     prev.left = rootLeft;
                   } else {
                    prev.right = root.left;
                   }
                } else {
                    if(root.right != null) {
                     prev.left = root.right;
                     TreeNode rootLeft = root.left;
                     TreeNode temp = root.right.left;
                     prev = root.right;
                     while(temp != null) {
                        prev = temp;
                        temp = temp.left;
                     }
                     prev.left = rootLeft;
                   } else {
                    prev.left = root.left;
                   }
                }
            }
        }
        prev = root;
        if(key > root.val) removeNode(root.right, key);
        else removeNode(root.left, key);
    }
}