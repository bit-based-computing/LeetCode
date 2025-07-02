class Solution {
    int[] dx = { 0, 0, 1, -1 };
    int[] dy = { 1, -1, 0, 0 };

    public int swimInWater(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int[] x: dp) Arrays.fill(x, Integer.MAX_VALUE);
        dp[0][0] = grid[0][0];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> Integer.compare(a[2], b[2]));
        queue.add(new int[]{0, 0, grid[0][0]});
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0];
            int j = point[1];
            if(i == row - 1 && j == col -1) return point[2];
            // System.out.println(i + " " + j + " " + point[2]);
            for(int k = 0; k < 4; k++) {
                int ni = i + dx[k];
                int nj = j + dy[k];
                if(ni >= 0 && nj >= 0 && ni < row && nj < col) {
                    int max = Math.max(grid[ni][nj], point[2]);
                    if(max < dp[ni][nj]) {
                        dp[ni][nj] = max;
                        queue.add(new int[]{ni, nj, max});
                    }
                }
            }
        }
       return 0;
    }
}