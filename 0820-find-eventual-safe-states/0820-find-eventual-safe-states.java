class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> result = new ArrayList<>();
        int[] visit = new int[n];  // 0 = unvisited, 1 = unsafe, 2 = safe
        int[] color = new int[n];  // 0 = unvisited, 1 = visiting, 2 = visited

        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                dfs(i, graph, visit, color);
            }
        }

        for (int i = 0; i < n; i++) {
            if (visit[i] == 2) { // safe nodes
                result.add(i);
            }
        }
        return result;
    }

    private int dfs(int node, int[][] graph, int[] visit, int[] color) {
        if (color[node] == 1) return visit[node] = 1; // cycle → unsafe
        if (color[node] == 2) return visit[node];     // already processed

        color[node] = 1;  // mark visiting
        visit[node] = 2;  // assume safe first

        for (int next : graph[node]) {
            if (dfs(next, graph, visit, color) == 1) {
                visit[node] = 1; // unsafe if any neighbor is unsafe
            }
        }

        color[node] = 2; // mark finished
        return visit[node];
    }
}
