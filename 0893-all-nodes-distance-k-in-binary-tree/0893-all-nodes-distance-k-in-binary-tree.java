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
    Set<Integer> set;
    int reqDist= 0;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        int[] dist = new int[501];
        set = new HashSet<>();
        if(root == null || target == null) return new ArrayList<>();
        Arrays.fill(dist, -1);
        dist[target.val] = 0;
        reqDist = k;
        dfs(root, dist);
        // System.out.println("Second=======");
        dfs(root, dist);
        return new ArrayList<>(set);
    }

    void dfs(TreeNode root, int[] dist) {
        if(root == null) return;
        // System.out.println(root.val + " " + dist[root.val]);
        int rootDis = dist[root.val];
        if(rootDis != -1) {
            if(root.right != null && dist[root.right.val] == -1) dist[root.right.val] = 1 + rootDis;
            if(root.left != null && dist[root.left.val] == -1) dist[root.left.val] = 1 + rootDis;
        }
        dfs(root.right, dist);
        dfs(root.left, dist);
        if(dist[root.val] == -1 && root.right != null && dist[root.right.val] != -1) {
            dist[root.val] = 1 + dist[root.right.val];
        }
        if(dist[root.val] == -1 && root.left != null && dist[root.left.val] != -1) {
            dist[root.val] = 1 + dist[root.left.val];
        }
        if(dist[root.val] == reqDist) set.add(root.val);
    }
}