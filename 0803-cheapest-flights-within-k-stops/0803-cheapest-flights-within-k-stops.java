class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        for(int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for(int[] flight: flights) {
            if(edges.get(flight[0]) == null) edges.put(flight[0], new ArrayList<>());
            edges.get(flight[0]).add(flight);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src,0});
        while(!queue.isEmpty() && k >= 0 ) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] node = queue.poll();
                if(edges.get(node[0]) != null) {
                    for(int[]edge: edges.get(node[0])) {
                        if(k == 0 && edge[1] != dst) continue;
                        if(node[1] + edge[2] < dist[edge[1]]) {
                            dist[edge[1]] = node[1] + edge[2];
                            queue.offer(new int[] {edge[1], dist[edge[1]]});
                        }
                    }
                }
            }
            k--;
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}