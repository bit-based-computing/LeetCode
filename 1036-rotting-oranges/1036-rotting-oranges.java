class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] time = new int[row][col];
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};

        for(int i=0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 0 || grid[i][j] == 2) time[i][j] = 0;
                if(grid[i][j] == 1) time[i][j] = -1;
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    while(!queue.isEmpty()) {
                        int[] x = queue.poll();
                        for(int k = 0; k < 4; k++) {
                            int ni = x[0] + dy[k];
                            int nj = x[1] + dx[k];

                            if(ni >= 0 && nj >= 0 && ni < row && nj < col && grid[ni][nj] == 1) {
                                if(time[ni][nj] == -1 || time[ni][nj] > time[x[0]][x[1]] + 1) {
                                    time[ni][nj]  = time[x[0]][x[1]] + 1;
                                    queue.add(new int[] {ni, nj});
                                }
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(time[i][j] == -1) return -1;
                ans = Math.max(ans, time[i][j]);
            }
        }

        return ans;
    }
}