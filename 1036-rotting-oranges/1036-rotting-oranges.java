class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) freshCount++;
                if(grid[i][j] == 2) queue.offer(new int[] {i,j});
            }
        }

        int times = 0;
        while(!queue.isEmpty() && freshCount > 0) {
            times++;

            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] point = queue.poll();

                for(int k = 0; k < 4; k++) {
                    int ni = point[0] + dx[k];
                    int nj = point[1] + dy[k];

                    if(ni >= 0 && ni < row && nj >= 0 && nj < col && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        freshCount--;
                        queue.offer(new int[]{ni,nj});
                    }
                }
            }
        }

        return freshCount == 0 ? times: -1;

        
    }
}