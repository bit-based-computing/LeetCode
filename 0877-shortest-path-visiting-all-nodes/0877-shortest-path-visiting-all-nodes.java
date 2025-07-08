class Solution {
    public int shortestPathLength(int[][] graph) {

        int n = graph.length;
        int finalState = (1 << n) - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];

        for(int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i});
        }
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] curr =queue.poll();
                int node = curr[0];
                int state = curr[1];

                if(state == finalState) return steps;

                for (int neighbor : graph[node]) {                    
                    int nextState = state | (1 << neighbor);
                    if (!visited[neighbor][nextState]) {
                        visited[neighbor][nextState] = true;
                        queue.add(new int[]{neighbor, nextState});
                    }
                }

            }
            steps++;
        }
        return -1;
    }
}