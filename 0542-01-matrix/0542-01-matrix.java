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
                    visit[i][j] = -1;
                } else {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int x = queue.peek()[0];
                int y = queue.peek()[1];
                queue.poll();
                int ans = Integer.MAX_VALUE;
                for(int k = 0; k < 4; k++) {
                    int ni = x + dx[k];
                    int nj = y + dy[k]; 
                    if(ni >= 0 && nj >= 0 && ni < row && nj < col && visit[ni][nj] == -1) {
                        visit[ni][nj]= 1 + visit[x][y];
                        queue.offer(new int[]{ni,nj});
                    }
                }
            }
        }
        return visit;
    }
}