class Solution {

    int[] dx = {0, 0, -1, 1};
    int [] dy = {1, -1, 0, 0};

    public boolean isValid(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        int row = grid.length;
        int col = grid[0].length;
        for(int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if(isValid(ni,nj,row,col) && grid[ni][nj] == '1'){
                dfs(grid, ni, nj);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
}