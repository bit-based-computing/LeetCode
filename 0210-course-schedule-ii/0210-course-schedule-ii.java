class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] edges =  new List[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int[] fans = new int[numCourses];
        int a,b;
        for(int i = 0; i < prerequisites.length; i++){
            a = prerequisites[i][0];
            b = prerequisites[i][1];
            if(edges[b] == null){
                edges[b] = new ArrayList<Integer>();
            }
            indegree[a]++;
            edges[b].add(a);
        }
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                indegree[i]--;
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            fans[count] = node;
            count++;
            List<Integer> childNodes = edges[node];
            for(int i = 0; childNodes != null && i < childNodes.size(); i++) {
                indegree[childNodes.get(i)]--;
                if(indegree[childNodes.get(i)] == 0){
                    q.add(childNodes.get(i));
                }
            }
        }
        if(count == numCourses) return fans;
        return new int[0];
    }
}