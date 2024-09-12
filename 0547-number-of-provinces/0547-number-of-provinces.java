class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        int len = isConnected.length;
        for( int i = 0; i < len; i++) {
            if(!visited[i]) {
                visited[i] = true;
                count++;
                q.add(i);
                while(!q.isEmpty()) {
                    int city = q.poll();
                    for(int j = 0; j < len; j++) {
                        if(isConnected[city][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
                
            }
        }
        return count;
    }
}