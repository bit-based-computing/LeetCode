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

    public boolean contains(int[] arr, int value) {
        for (int num : arr) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    public void getAllForest(TreeNode parent, TreeNode root, int[] to_delete, List<TreeNode> list) {
        if (root == null) return;
        getAllForest(root, root.left, to_delete, list);
        getAllForest(root, root.right, to_delete, list);
        if (contains(to_delete, root.val)) {
            if (root.left != null) list.add(root.left);
            if (root.right != null) list.add(root.right);
            if (parent != null) {
                if (parent.left == root) parent.left = null;
                else if (parent.right == root) parent.right = null;
            }
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        getAllForest(null, root, to_delete, list);
        if(!contains(to_delete, root.val)) {
            list.add(root);
        }
        return list;
    }
}