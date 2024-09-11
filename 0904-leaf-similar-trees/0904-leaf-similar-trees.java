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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        collectAllLeaf(root1, list1);
        collectAllLeaf(root2, list2);
        if(list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if((int)list1.get(i) != (int)list2.get(i)) {
                    return false;
                } 
            }
            return true;
        }
        return false;
    }

    private void collectAllLeaf(TreeNode root, List<Integer> list) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            collectAllLeaf(root.left, list);
            collectAllLeaf(root.right, list);
        }
    }
}