class Solution {
    int[] dx = new int[] {0, 0, 1, -1};
    int[] dy = new int[] {1, -1, 0, 0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new  boolean [row][col];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            dfs(i, 0, heights, pacific);
            dfs(i, col -1, heights, atlantic);
        }

        for(int j = 0; j < col; j++) {
            dfs(0, j, heights, pacific);
            dfs(row-1, j, heights, atlantic);
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    ans.add(List.of(i,j));
                }
            }
        }

        return ans;

    }

    void dfs(int x, int y, int[][] heights, boolean[][] visited) {
        visited[x][y] = true;
        for(int k = 0; k < 4; k++) {
            int ni = x + dx[k];
            int nj = y + dy[k];
            if(ni < 0 || ni >= heights.length || nj < 0 || nj >= heights[0].length) continue;
            if(visited[ni][nj]) continue;
            if(heights[ni][nj] < heights[x][y]) continue;
            dfs(ni, nj, heights, visited);
        }
    }
}