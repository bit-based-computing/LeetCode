class Solution {
    int cameras = 0;

    public int minCameraCover(TreeNode root) {
        // If root is not covered, we need an extra camera
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }

    // Return states: 0 = not covered, 1 = covered, 2 = has camera
    private int dfs(TreeNode node) {
        if (node == null) return 1; // null nodes are covered

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 0 || right == 0) {
            cameras++;
            return 2; // Place a camera here
        }

        if (left == 2 || right == 2) {
            return 1; // Covered by child's camera
        }

        return 0; // Not covered
    }
}
