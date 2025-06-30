class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            int i = time[0];
            int j = time[1];
            int cost = time[2];
            if (map.get(i) == null)
                map.put(i, new ArrayList<>());
            map.get(i).add(new int[] { j, cost });
        }
        int ans = -1;
        int count = 0;
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> Integer.compare(a[1], b[1]));
        queue.offer(new int[]{k, 0});
        cost[k] = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            int[] node = queue.poll();
                ans = Math.max(ans, cost[node[0]]);
                if (map.get(node[0]) != null) {
                    for (int[] edge : map.get(node[0])) {
                        if (cost[node[0]] + edge[1] < cost[edge[0]]) {
                            cost[edge[0]] = cost[node[0]] + edge[1];
                            queue.offer(new int[]{edge[0], cost[edge[0]]});
                        }
                    }
                }
        }

        for(int i = 1 ; i <= n; i++) if(cost[i] == Integer.MAX_VALUE) return -1;
        return ans;
    }
}