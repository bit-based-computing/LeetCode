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
class BSTIterator {
    int current = 0;
    int i = 0;
    int size = 0;
    Map<Integer, Integer> map;
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        map.put(i++, root.val);
        inorder(root.right);
    }
    public BSTIterator(TreeNode root) {
        map = new HashMap<>();
        inorder(root);
        size = i;
    }
    
    public int next() {
        int x = map.get(current);
        current++;
        return x;
    }
    
    public boolean hasNext() {
        if(current < size) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */