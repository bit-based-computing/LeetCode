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
    void getPaths(TreeNode root, StringBuilder s, List<String> paths) {
        if(root.left == null && root.right == null) {
            paths.add(s.toString());
            return;
        }
        int startIndex = s.length();
        if(root.left != null) {
            s.append("->");
            s.append(String.valueOf(root.left.val));
            getPaths(root.left, s, paths);
            s.delete(startIndex, s.length());
        }
        if(root.right != null) {
            s.append("->");
            s.append(String.valueOf(root.right.val));
            getPaths(root.right, s, paths);
            s.delete(startIndex, s.length());
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null) return paths;
        StringBuilder s = new StringBuilder();
        s.append(String.valueOf(root.val));
        getPaths(root, s,  paths);
        return paths;
    }
}