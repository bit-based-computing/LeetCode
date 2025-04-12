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
    TreeNode ancestor;
    void getAncestor(TreeNode root, TreeNode p, List<TreeNode> list) {
        if(root == null) return ;
        if(ancestor != null) return;
        if(root.val == p.val) ancestor = root;
        if(ancestor == null)getAncestor(root.left, p, list);
        if(ancestor == null )getAncestor(root.right, p, list);
        if(ancestor != null)list.add(root);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listp = new ArrayList<>();
        List<TreeNode> listq = new ArrayList<>();
        getAncestor(root, p, listp);
        ancestor = null;
        getAncestor(root, q, listq);
        Collections.reverse(listp);
        Collections.reverse(listq);
        int size = Math.min(listp.size(), listq.size());
        ancestor = root;
        for(int i = 0; i < size; i++) {
            if(listp.get(i) == listq.get(i)) {
                ancestor = listp.get(i);
            } else break;
        }
        return ancestor;
    }
}