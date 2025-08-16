import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int shortestPath(int[][] grid, int k) {
        int row = grid.length, col = grid[0].length;

        // If we can remove enough obstacles to go straight line
        if (k >= row + col - 2) return row + col - 2;

        boolean[][][] visited = new boolean[row][col][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, k});
        visited[0][0][k] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1], obs = curr[2];

                if (x == row - 1 && y == col - 1) return steps;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;

                    int newObs = obs - grid[nx][ny]; // if obstacle, consume 1
                    if (newObs >= 0 && !visited[nx][ny][newObs]) {
                        visited[nx][ny][newObs] = true;
                        queue.add(new int[]{nx, ny, newObs});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
