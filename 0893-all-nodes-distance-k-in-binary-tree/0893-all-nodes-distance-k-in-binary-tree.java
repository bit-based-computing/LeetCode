class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        int[] dist = new int[501];
        Arrays.fill(dist, -1);
        dist[target.val] = 0;

        dfs(root, dist);  // Downward
        dfs(root, dist);  // Upward or missing propagation

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 500; i++) {
            if (dist[i] == k) list.add(i);
        }

        return list;
    }

    void dfs(TreeNode node, int[] dist) {
        if (node == null) return;

        int d = dist[node.val];
        if (d != -1) {
            if (node.left != null && dist[node.left.val] == -1)
                dist[node.left.val] = d + 1;
            if (node.right != null && dist[node.right.val] == -1)
                dist[node.right.val] = d + 1;
        }

        dfs(node.left, dist);
        dfs(node.right, dist);

        // After children
        if (dist[node.val] == -1) {
            if (node.left != null && dist[node.left.val] != -1)
                dist[node.val] = dist[node.left.val] + 1;
            else if (node.right != null && dist[node.right.val] != -1)
                dist[node.val] = dist[node.right.val] + 1;
        }
    }
}
