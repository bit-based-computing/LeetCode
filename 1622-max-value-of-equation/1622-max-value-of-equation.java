class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> Integer.compare(b[1]-b[0], a[1]-a[0]));
        for(int[] point: points) {
            if(!pq.isEmpty()) {
                while(!pq.isEmpty() && Math.abs(pq.peek()[0] - point[0]) > k) pq.poll();
                if(!pq.isEmpty()) {
                    max = Math.max(max, Math.abs(pq.peek()[0] - point[0]) + pq.peek()[1] + point[1]);
                }
            }
            pq.offer(point);
        }
        return max;
    }
}