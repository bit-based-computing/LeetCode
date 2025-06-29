class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 1;
        for(i = 1; i < len; i++) {
            if(heights[i] > heights[i-1]) {
                int diff = heights[i] - heights[i-1];
                if(ladders > 0) {
                    pq.offer(diff);
                    ladders--;
                } else {
                    if(!pq.isEmpty() && pq.peek() < diff && pq.peek() <= bricks) {
                        int peek = pq.poll();
                        bricks -= peek;
                        pq.offer(diff);
                    } else if(diff <= bricks){
                        bricks -= diff;
                    } else {
                        break;
                    }
                }
            }
        }

        return i-1;

    }
}
