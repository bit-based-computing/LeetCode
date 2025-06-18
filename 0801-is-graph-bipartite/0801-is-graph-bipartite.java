class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len];
        int row = len;
        int col = 0;
        int parent = 0;
        for (int i = 0; i < len; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                while (!queue.isEmpty()) {
                    parent = queue.poll();
                    col = graph[parent].length;
                    for (int j = 0; j < col; j++) {
                        int node = graph[parent][j];
                        if (color[node] == 0) {
                            color[node] = color[parent] * -1;
                            queue.add(node);
                        } else if (color[node] == color[parent]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}