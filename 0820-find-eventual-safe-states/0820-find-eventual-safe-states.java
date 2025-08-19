class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        List<Integer> results = new ArrayList<>();
        int[] visit = new int[len];
        int[] color = new int[len];
        for(int i = 0; i < len; i++) {
            if(visit[i] == 0) dfs(i, graph, visit, color);
        }
        for(int i = 0; i < len; i++) {
            // System.out.println(i + " " + visit[i]);
            if(visit[i] < 2) results.add(i);
        }
        return results;
    }

     int dfs(int node, int[][] graph, int[] visit, int[] color) {
        if(color[node] == 1) return 2;
        if(color[node] == 2) return visit[node];
        visit[node] = 1;
        color[node] = 1;
        for(int i = 0; i < graph[node].length; i++) {
            int nextNode = graph[node][i];
            visit[node] = Math.max(visit[node], dfs(nextNode, graph, visit, color));
        }
        color[node] = 2;
        return visit[node];
    }
}