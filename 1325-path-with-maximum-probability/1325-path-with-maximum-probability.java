class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] cost = new double[10001];
        Map<Integer, List<double[]>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if(map.get(edge[0]) == null) map.put(edge[0], new ArrayList<>());
            if(map.get(edge[1]) == null) map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(new double[]{edge[1], succProb[i]});
             map.get(edge[1]).add(new double[]{edge[0], succProb[i]});
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start_node);
        while(!queue.isEmpty()) {
            int node = (int)queue.poll();
            if(node == end_node) continue;
            double nValue = cost[node] == 0 ? 1 : cost[node];
            List<double[]> paths = map.getOrDefault(node, new ArrayList<>());
            for(int i = 0; i < paths.size(); i++) {
                double[] path = paths.get(i);
                
                int nextNode = (int)path[0];
                double prob = path[1];
                String way = "";
                if(node < nextNode) way = node +"->"+nextNode;
                else way = nextNode+"->"+node;
                if((nValue * prob) > cost[nextNode]) {
                        cost[nextNode] = (nValue * prob);
                        queue.add(nextNode);
                    }
            }

        }

        return cost[end_node];
    }
}