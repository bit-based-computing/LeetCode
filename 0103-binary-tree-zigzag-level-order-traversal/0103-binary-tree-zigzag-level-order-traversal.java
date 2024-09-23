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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        addNodes(root, list, 0);
        return list;
    }

    private void addNodes(TreeNode root, List<List<Integer>> list, int level) {
        if(root == null) return ;
        if(level >= list.size())
            list.add(new ArrayList<Integer>());
        if(level % 2 == 1) {
            List<Integer> rlist = new ArrayList<>();
            rlist.add(root.val);
            rlist.addAll(list.get(level));
            list.set(level, rlist);
        } else {
            list.get(level).add(root.val);
        }
        
        addNodes(root.left, list, level + 1);
        addNodes(root.right, list, level + 1);
        
    }
}