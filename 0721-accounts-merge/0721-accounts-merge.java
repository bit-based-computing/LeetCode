class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (List<String> accs : accounts) {
            for (int i = 1; i < accs.size(); i++) {
                graph.computeIfAbsent(accs.get(i), k -> new ArrayList<>());
                if (i > 1) {
                    String s1 = accs.get(i-1);
                    String s2 = accs.get(i);
                    graph.get(s1).add(s2);
                    graph.get(s2).add(s1);
                }
            }
        }

        // DFS for connected components
        for (List<String> accs : accounts) {
            String email = accs.get(1);
            if (visited.add(email)) {
                List<String> emailList = new ArrayList<>();
                dfs(email, graph, visited, emailList);
                Collections.sort(emailList);

                List<String> merged = new ArrayList<>();
                merged.add(accs.get(0));
                merged.addAll(emailList);
                ans.add(merged);
            }
        }
        return ans;
    }

    void dfs(String email, Map<String, List<String>> graph, Set<String> visited, List<String> emailList) {
        emailList.add(email);
        for (String neighbor : graph.getOrDefault(email, new ArrayList<>())) {
            if (visited.add(neighbor)) {
                dfs(neighbor, graph, visited, emailList);
            }
        }
    }
}
