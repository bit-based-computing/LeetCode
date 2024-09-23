class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            int room = q.poll();
            set.add(room);
            List<Integer>keys = rooms.get(room);
            for(int i = 0; i < keys.size(); i++) {
                int key = keys.get(i);
                if(!set.contains(key)) {
                    q.add(key);
                }
            }
        }

       return set.size() == rooms.size();
    }
}