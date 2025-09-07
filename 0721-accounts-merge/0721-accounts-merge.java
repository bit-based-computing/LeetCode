class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();
        for(List<String> accs: accounts) {
            for(int i = 2; i < accs.size(); i++) {
                String s1 = accs.get(i-1);
                String s2 = accs.get(i);
                graph.computeIfAbsent(s1, k-> new ArrayList<>()).add(s2);
                graph.computeIfAbsent(s2, k-> new ArrayList<>()).add(s1);
            }
         }

         for(List<String> accs: accounts) {
            String s = accs.get(1);
            if(visited.get(s) == null) {
                List<String> aclist = new ArrayList<>();
                dfs(s, graph, visited, aclist);
                Collections.sort(aclist);
                List<String> facList = new ArrayList<>();
                facList.add(accs.get(0));
                facList.addAll(aclist);
                ans.add(facList);
            }

         }
        return ans;
    }

    void dfs(String s, Map<String, List<String>> graph,  Map<String, Boolean> visited, List<String> aclist) {
        visited.put(s, true);
        aclist.add(s);
        List<String> edges =  graph.getOrDefault(s, new ArrayList<>());
        for(String edge: edges) {
            if(visited.get(edge) == null) {
                dfs(edge, graph, visited, aclist);
            }
        }
    }
}