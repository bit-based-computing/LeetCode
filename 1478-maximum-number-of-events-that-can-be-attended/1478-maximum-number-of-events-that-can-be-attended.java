class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int maxDay = 0;
        for(int[] event: events) maxDay = Math.max(maxDay, event[1]);
        int day = 1;
        int i = 0;
        int len = events.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        while(day <= maxDay) {
            
            while(i < len && events[i][0] == day) {
                pq.offer(events[i++][1]);
            }

             while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if(!pq.isEmpty()) {
                pq.poll();
                count++;
            }
            day++;
        }
        return count;
    }
}