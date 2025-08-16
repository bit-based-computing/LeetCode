class Solution {
    
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public int shortestPath(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        if(grid[0][0] == 1) {
            if(k == 0) return -1;
            k--;
        }
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, Set<String>> map = new HashMap<>();
        int count = 0;
        queue.add(new int[]{0,0,k});
        map.put(k, new HashSet<>());
        map.get(k).add(0+"-"+0);
        while(!queue.isEmpty()) {
            int size  = queue.size();
            for(int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                int obsR = point[2];
                if(x == row -1 && y == col -1) return count;

                for(int z = 0; z < 4; z++) {
                    int ni = x + dx[z];
                    int nj = y + dy[z];
                    if(ni >= 0 && ni < row && nj >= 0 && nj < col) {
                        if(grid[ni][nj] == 1 && obsR == 0) continue;
                        if(map.get(obsR) == null) map.put(obsR, new HashSet<>());
                        if(map.get(obsR-1) == null) map.put(obsR-1, new HashSet<>());
                        if(grid[ni][nj] == 1 && map.get(obsR-1).add(ni+"-"+nj)) {
                            queue.add(new int[]{ni, nj, obsR-1});
                        } else if(grid[ni][nj] == 0 && map.get(obsR).add(ni+"-"+nj)) {
                            queue.add(new int[]{ni, nj, obsR});
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}