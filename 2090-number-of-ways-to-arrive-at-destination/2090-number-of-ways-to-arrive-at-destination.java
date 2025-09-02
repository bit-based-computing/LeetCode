class Solution {
    public int countPaths(int n, int[][] roads) {

        final int MOD = 1_000_000_007;

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] road : roads) {
            int from = road[0], to = road[1], time = road[2];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, time});
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[]{from, time});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];

        PriorityQueue<long[]> pq  = new PriorityQueue<>((a,b)-> Long.compare(a[1], b[1]));
        pq.add(new long[]{0,0});
        dist[0] = 0;
        ways[0] = 1;

        while(!pq.isEmpty()) {

            long[] curr = pq.poll();
            int node = (int) curr[0];
            long d = curr[1];

            if (d > dist[node]) continue;

            for (int[] edge : graph.getOrDefault(node, new ArrayList<>())) {
                int nei = edge[0];
                long newDist = d + edge[1];

                // Found shorter path
                if (newDist < dist[nei]) {
                    dist[nei] = newDist;
                    ways[nei] = ways[node]; // inherit path count
                    pq.add(new long[]{nei, newDist});
                }
                // Found another shortest path
                else if (newDist == dist[nei]) {
                    ways[nei] = (int) ((ways[nei] + (long) ways[node]) % MOD);
                }
            }
        }
        return ways[n - 1] % MOD;
    }
}