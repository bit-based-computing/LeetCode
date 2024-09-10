class Solution {
    public int equalPairs(int[][] grid) {
        int row = grid.length;
        int col = row;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                for(int k = 0; k < row; k++){
                    if(grid[i][k] == grid[k][j]) count++;
                    else break;
                }
                if(count == row) ans++;
            }
        }
        return ans;
    }
}