class Solution {
    List<List<Integer>> paths;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths =  new ArrayList<>();
        int endNode = graph.length - 1;
        getAllPaths(0, endNode, graph, new ArrayList<>(List.of(0)));
        return paths;
    }

    void getAllPaths(int curNode, int endNode, int[][] graph, List<Integer> path) {
        if (curNode == endNode) {
            paths.add(new ArrayList<>(path));
        }
        for (int x : graph[curNode]) {
            path.add(x);
            getAllPaths(x, endNode, graph, path);
            path.remove(path.size() - 1);
        }
    }
}