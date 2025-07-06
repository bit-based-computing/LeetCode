class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() <= 1) {
                leaves.add(i);
            }
        }
        int totalNodes = n;
        while(totalNodes > 2) {
            int size = leaves.size();
            totalNodes -= size;
            for(int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                int neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove((Integer)leaf);
                if(graph.get(neighbor).size() == 1) leaves.add(neighbor);
            }
        }
        List<Integer> roots = new ArrayList<>();
        while(!leaves.isEmpty()) {
            roots.add(leaves.poll());
        }
        return roots;
    }
}