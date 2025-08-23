import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // adjacency list
        Map<Integer, List<double[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new double[]{v, succProb[i]});
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new double[]{u, succProb[i]});
        }

        // max probability to reach each node
        double[] prob = new double[n];
        prob[start] = 1.0;

        // max-heap: store {probability, node}
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        pq.offer(new double[]{1.0, start});

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            double p = curr[0];
            int node = (int) curr[1];

            if (node == end) return p; // best probability found

            if (p < prob[node]) continue; // skip if outdated

            for (double[] nei : graph.getOrDefault(node, Collections.emptyList())) {
                int next = (int) nei[0];
                double edgeProb = nei[1];
                double newProb = p * edgeProb;

                if (newProb > prob[next]) {
                    prob[next] = newProb;
                    pq.offer(new double[]{newProb, next});
                }
            }
        }

        return 0.0;
    }
}
