class Solution {
    public int[] getOrder(int[][] tasks) {
        int len = tasks.length;
        int[] ans = new int[len];
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int i = 0; i < len; i++) {
            int inq = tasks[i][0];
            set.add(inq);
            if(map.get(inq) == null) map.put(inq, new ArrayList<>());
            map.get(inq).add(new int[]{i, tasks[i][1]});
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int time = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            if(a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int i = 0;
        int j = 0;

        while(j < list.size()) {
            time = list.get(j);
            pq.addAll(map.get(list.get(j)));
            j++;
            while(!pq.isEmpty()) {
                int[] task = pq.poll();
                ans[i++] = task[0];
                time += task[1];
                while(j < list.size() && list.get(j) <= time) {
                    pq.addAll(map.get(list.get(j)));
                    j++;
                }
            }
        }
        return ans;
    }
}