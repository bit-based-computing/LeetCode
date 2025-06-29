class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 1;
        for (i = 1; i < len; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff <= 0)
                continue;
            pq.add(diff);
            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }
            if (bricks < 0)
                break;
        }

        return i - 1;

    }
}
