class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int i = 0;
        int j = 0;
        return isValid(0,0,row,col,grid);
    }
    private boolean isValid(int i, int j, int row, int col, int[][] grid) {
            if(i >= row || j >= col) return true;
            if (i + 1 < row && grid[i][j] != grid[i + 1][j]) return false;
            if (j + 1 < col && grid[i][j] == grid[i][j + 1]) return false;
            return isValid(i + 1, j, row, col, grid) && isValid(i, j + 1, row, col, grid);
    }
}