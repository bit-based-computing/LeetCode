class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(grid[row-1][col-1] == 1 || grid[0][0] == 1) return 0;
        int[][] dp = new int[row][col];
        for(int[] x: dp) Arrays.fill(x, -1);
        return way(0,0, grid, dp);
    }

    int way(int i, int j, int[][] grid, int[][] dp) {
        int row = grid.length;
        int col = grid[0].length;
        if(i == grid.length -1 && j == grid[0].length-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int x = 0, y = 0;
        if(i + 1 < row && grid[i+1][j] == 0) {
            x = way(i+1, j, grid, dp);
        } 
        if(j+1 < col && grid[i][j+1] == 0) {
            y = way(i, j+1, grid, dp);
        }
        dp[i][j] = x + y;
        return dp[i][j];
    }
}