class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] x : prerequisites) {
            indegree[x[0]]++;
            if (map.get(x[1]) == null)
                map.put(x[1], new ArrayList<Integer>());
            map.get(x[1]).add(x[0]);

        }
        int[] ans = new int[numCourses];
        int k = 0;
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (indegree[j] == 0) {
                    ans[k++] = j;
                    indegree[j] = -1;
                    if (map.get(j) != null) {
                        for (Integer course : map.get(j)) {
                            indegree[course]--;
                        }
                    }
                }
            }
        }
        if (k >= numCourses)
            return ans;
        return new int[0];
    }
}