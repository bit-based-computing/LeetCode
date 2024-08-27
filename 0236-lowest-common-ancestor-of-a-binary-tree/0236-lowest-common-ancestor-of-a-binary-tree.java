/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hasPAndQ(root, p, q);
        return lca;
    }

    private int hasPAndQ(TreeNode root, TreeNode p, TreeNode q) {
        int ret = 0;
        if (root == null) return 0;
        if (root.val == p.val || root.val == q.val) ret++;
        ret += hasPAndQ(root.left, p, q);
        ret += hasPAndQ(root.right, p, q);
        if (ret == 2 && lca == null) lca = root;
        return ret;
    }
}