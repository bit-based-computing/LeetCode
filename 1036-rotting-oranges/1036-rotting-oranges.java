class Solution {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<List<Integer>> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    grid[i][j] = -1;
                    q.add(List.of(i,j));
                }
            }
        }
        int count = -1;
        while(!q.isEmpty()) {
            count++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                List<Integer> l = q.poll();
                int r = l.get(0);
                int c = l.get(1);
                for(int j = 0; j < 4; j++) {
                    int nr = r + dx[j];
                    int nc = c + dy[j];
                    if(nr >=0 && nr < row && nc >=0 && nc < col && grid[nr][nc] == 1) {
                        grid[nr][nc] = -1;
                        q.add(List.of(nr,nc));
                    }
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        count = Math.max(count, 0);
        return count;
    }
}