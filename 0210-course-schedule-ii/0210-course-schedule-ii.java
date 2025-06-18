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

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i < numCourses; i++) {
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();
            ans[k++] = course;
            if(map.get(course) != null) {
                for(int x: map.get(course)) {
                    indegree[x]--;
                    if(indegree[x] == 0) queue.add(x);
                }
            }
        }
        

        if (k >= numCourses) return ans;
        return new int[0];
    }
}