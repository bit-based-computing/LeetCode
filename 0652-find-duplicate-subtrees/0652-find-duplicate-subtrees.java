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
    List<TreeNode> list;
    Map<String, Integer> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        list = new ArrayList<>();
        map = new HashMap<>();
        serialize(root);
        return list;
    }

    public String serialize(TreeNode root) {
        if(root == null) return "#";
        String s = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        map.put(s,map.getOrDefault(s,0) + 1);
        if(map.get(s) == 2) list.add(root);
        return s;
    }
}