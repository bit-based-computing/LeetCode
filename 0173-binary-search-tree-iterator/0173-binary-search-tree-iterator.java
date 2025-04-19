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
    List<Integer> list;
    Map<Integer, Integer> map;
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        map = new HashMap<>();
        inorder(root);
        for(int i = 0; i < list.size(); i++) {
            map.put(i, list.get(i));
        }
    }
    
    public int next() {
        int x = map.get(current);
        current++;
        return x;
    }
    
    public boolean hasNext() {
        if(current < list.size()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */