class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> Integer.compare(b, a));

        for(int[] a: matrix) {
            for(int item: a) {
                if(pq.size() < k || pq.peek() > item) {
                    pq.offer(item);
                    if(pq.size() > k) pq.poll();
                }
            }
        }
        return pq.peek();
    }
}