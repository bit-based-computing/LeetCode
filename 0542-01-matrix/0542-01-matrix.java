class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] visit = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i < row; i++) {
            for(int j = 0; j < col; j++)  {
                if(mat[i][j] == 1) {
                    visit[i][j] = -1; // unvisited
                } else {
                    queue.offer(new int[]{i, j}); // start BFS from all 0s
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            for(int k = 0; k < 4; k++) {
                int ni = x + dx[k];
                int nj = y + dy[k];
                if(ni >= 0 && nj >= 0 && ni < row && nj < col && visit[ni][nj] == -1) {
                    visit[ni][nj] = visit[x][y] + 1;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }

        return visit;
    }
}
