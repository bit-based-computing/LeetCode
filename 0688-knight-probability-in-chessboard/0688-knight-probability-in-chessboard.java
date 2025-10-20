class Solution {
    private static final int[][] DIRECTIONS = {
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };
    
    private double[][][] memo;
    private int n;

    public double knightProbability(int n, int k, int row, int column) {
        this.n = n;
        memo = new double[n][n][k + 1];
        
        // Initialize memo with -1 (uncomputed state)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int t = 0; t <= k; t++) {
                    memo[i][j][t] = -1.0;
                }
            }
        }
        
        return dfs(row, column, k);
    }

    private double dfs(int r, int c, int k) {
        // If knight goes out of the board
        if (r < 0 || r >= n || c < 0 || c >= n) {
            return 0.0;
        }

        // Base case: no more moves, still on the board
        if (k == 0) {
            return 1.0;
        }

        // Return memoized value if already computed
        if (memo[r][c][k] != -1.0) {
            return memo[r][c][k];
        }

        double prob = 0.0;
        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            prob += dfs(nr, nc, k - 1) / 8.0;
        }

        memo[r][c][k] = prob;
        return prob;
    }

}
