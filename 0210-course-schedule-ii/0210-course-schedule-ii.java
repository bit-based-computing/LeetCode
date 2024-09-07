class Solution {
    public int[] findOrder(int numCourses, int[][] p) {
        if(numCourses == 1) return new int[]{0};
        int[] indegree = new int[numCourses];
        int[] outdegree = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int len = p.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            indegree[p[i][0]]++;
            if(map.containsKey(p[i][1])) {
                map.get(p[i][1]).add(p[i][0]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(p[i][0]);
                map.put(p[i][1], set);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for ( int i = 0; i < numCourses; i++) {
                if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int c = q.poll();
            ans.add(c);
            if(map.containsKey(c)) {
                Set<Integer> s = map.get(c);
                for(int rc: s) {
                    indegree[rc]--;
                    if(indegree[rc] == 0) q.add(rc);
                }
            }
        }
     if(ans.size() == numCourses) return ans.stream().mapToInt(Integer::intValue).toArray();
     return new int[] {};

    }
}