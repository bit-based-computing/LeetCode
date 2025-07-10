class Solution {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length - 1;
        int col = heights[0].length - 1;
        int[][] efforts = new int[row+1][col+1];
        for(int[] x: efforts) Arrays.fill(x, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0,0,0});
        efforts[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] point = pq.poll();
            // System.out.println(point[0] + " " + point[1] + " " + heights[point[0]][point[1]] + "   " + point[2]);
            if(point[0] == row && point[1] == col) {
                return point[2];
            }
            for(int k = 0; k < 4; k++) {
                int i = point[0] + dx[k];
                int j = point[1] + dy[k];
                if(i >= 0 && j >= 0 && i <= row && j <= col) {
                    int effort =  Math.abs(heights[i][j] - heights[point[0]][point[1]]);
                    effort = Math.max(point[2], effort);
                    if(effort < efforts[i][j]) {
                        efforts[i][j] = effort;
                        pq.offer(new int[]{i, j, effort});
                    }
                }
            }
        }
        return -1;
    }
}