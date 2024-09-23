class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[1001];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        visit[0] = true;
        q.add(0);
        while(!q.isEmpty()) {
            count++;
            int room = q.poll();
            List<Integer>keys = rooms.get(room);
            for(int i = 0; i < keys.size(); i++) {
                int key = keys.get(i);
                if(!visit[key]) {
                    visit[key] = true;
                    q.add(key);
                }
            }
        }
       return count == rooms.size();
    }
}