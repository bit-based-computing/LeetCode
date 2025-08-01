class Solution {
    int[] dx = { 0, 0, 1, -1 };
    int[] dy = { 1, -1, 0, 0 };

    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        int iland = 2;
        Map<Integer, Integer> ilandsArea = new HashMap<>();
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid, iland);
                    maxArea = Math.max(maxArea, area);
                    ilandsArea.put(iland++, area);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer> neighbors = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < row && nj >= 0 && nj < col && grid[ni][nj] > 1) {
                            int neighbor = grid[ni][nj];
                            if (neighbors.add(neighbor))
                                area += ilandsArea.get(neighbor);
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    int dfs(int i, int j, int[][] grid, int iland) {
        grid[i][j] = iland;
        int row = grid.length;
        int col = grid[0].length;
        int count = 1;
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && ni < row && nj >= 0 && nj < col && grid[ni][nj] == 1) {
                count += dfs(ni, nj, grid, iland);
            }
        }
        return count;
    }
}