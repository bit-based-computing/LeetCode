class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            map.computeIfAbsent(time[0], a -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[k] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.offer(new int[]{k, 0});
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int currNode = node[0];
            int currCost = node[1];

            if (currCost > cost[currNode]) continue; // Skip outdated entries

            if (map.containsKey(currNode)) {
                for (int[] edge : map.get(currNode)) {
                    int neighbor = edge[0], weight = edge[1];
                    if (currCost + weight < cost[neighbor]) {
                        cost[neighbor] = currCost + weight;
                        queue.offer(new int[]{neighbor, cost[neighbor]});
                    }
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (cost[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, cost[i]);
        }

        return maxTime;
    }
}
