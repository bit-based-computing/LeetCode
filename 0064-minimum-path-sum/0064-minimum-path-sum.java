class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] ans = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        ans[0][0] = grid[0][0];
        dfs(0,0, row - 1, col - 1, grid, ans);
        return ans[row-1][col-1];
    }

    void dfs(int i, int j, int row, int col, int[][] grid, int [][] ans) {
        if(i + 1 <= row && grid[i+1][j] + ans[i][j] < ans[i+1][j]) {
            ans[i + 1][j] = grid[i+1][j] + ans[i][j];
            dfs(i + 1, j, row, col, grid, ans);
        }
        if( j + 1 <= col && grid[i][j+1] + ans[i][j] < ans[i][j+1]) {
            ans[i][j+1] = grid[i][j+1] + ans[i][j];
            dfs(i, j + 1, row, col, grid, ans);
        }
    }
}