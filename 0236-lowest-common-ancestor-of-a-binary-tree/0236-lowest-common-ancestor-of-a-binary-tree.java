/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   
    Map<TreeNode, TreeNode> map = new HashMap<>();
    Map<TreeNode, Boolean> visit = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        visitTree(root);

        visit.put(p, true);

        while(map.get(p) != null) {
            p = map.get(p);
            visit.put(p, true);
        }
        if(visit.get(q) != null) return q;

        while(map.get(q) != null) {
            q = map.get(q);
            if(visit.get(q) != null) return q;
        }
        return root;
    }
    private void visitTree(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            map.put(root.left, root);
            visitTree(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            visitTree(root.right);
        }
    }
}