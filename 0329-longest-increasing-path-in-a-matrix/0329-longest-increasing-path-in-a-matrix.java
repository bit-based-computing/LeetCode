class Solution {
    int[] dx = new int[] {0, 0, 1, -1};
    int[] dy = new int[] {1, -1, 0, 0};
    public int longestIncreasingPath(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 1;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                max = Math.max(max, dfs(i,j, matrix, dp));
            }
        }
        return max;        
    }

    public int dfs(int i, int j, int[][] matrix, int[][] dp) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(dp[i][j] != 0) return dp[i][j];
        int max = 1;
        for(int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if(ni >= 0 && ni < row && nj >= 0 && nj < col && matrix[i][j] < matrix[ni][nj]) {
                max = Math.max(max, 1 + dfs(ni, nj, matrix, dp));
            }
        }
        dp[i][j] = max;
        return max;
    }
}