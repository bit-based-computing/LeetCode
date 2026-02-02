class Solution {
    public int cherryPickup(int[][] grid) {
        int len = grid.length;

        int[][][] dp = new int[len][len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++)
                    dp[i][j][k] = -1;
            }
        }
        return Math.max(0, dfs(0, 0, 0, grid, dp));
    }

    int dfs(int r1, int c1, int r2, int[][] grid, int[][][] dp) {

        int len = grid.length;

        int c2 = r1 + c1 - r2;
        if (r1 >= len || c1 >= len || r2 >= len || c2 >= len ||
                grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return -10000000;

        if (dp[r1][c1][r2] != -1)
            return dp[r1][c1][r2];
        
        if(r1 == len - 1 && c1 == len - 1) return grid[r1][c1];

        int count = 0;
        if (r1 == r2 && c1 == c2 && grid[r1][c1] == 1)
            count = 1;
        else
            count = grid[r1][c1] + grid[r2][c2];

        dp[r1][c1][r2] = count + Math.max(
                Math.max(
                    dfs(r1 + 1, c1, r2 + 1, grid, dp),
                    dfs(r1, c1 + 1, r2, grid, dp)
                ),
                Math.max(
                    dfs(r1 + 1, c1, r2, grid, dp),
                    dfs(r1, c1 + 1, r2 + 1, grid, dp)
              )
            );
        return dp[r1][c1][r2];
    }
}