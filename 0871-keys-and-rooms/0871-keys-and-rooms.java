class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[1001];
        visit[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            int room = q.poll();
            visit[room] = true;
            List<Integer>keys = rooms.get(room);
            for(int i = 0; i < keys.size(); i++) {
                if(!visit[keys.get(i)]) {
                    q.add(keys.get(i));
                }
            }
        }

        for(int i = 0; i < rooms.size(); i++) {
            if(!visit[i]) return false;
        }

        return true;
    }
}