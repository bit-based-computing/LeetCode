class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int row = isConnected.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[201];
        for(int i = 0; i < row; i++) {
            if(!visited[i]) {
                count++;
                q.add(i);
                while(!q.isEmpty()) {
                    int index = q.poll();
                    visited[index] = true;
                    for(int j = 0; j < row; j++) {
                        if(isConnected[index][j] == 1 && !visited[j]) {
                            q.add(j);
                        }
                    }
                }
            }
        }
        return count;        
    }
}