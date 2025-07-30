class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));
        int len = nums.size();
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            int number = nums.get(i).get(0);
            max = Math.max(max, number);
            pq.offer(new int[]{number, i, 0});
        }

        while(pq.size() == nums.size()) {

            int oldDiff = end - start;
            int newDiff = max - pq.peek()[0];
            if(newDiff < oldDiff) {
                start = pq.peek()[0];
                end = max;
            }
            int[] peek = pq.poll();
            if(nums.get(peek[1]).size() > peek[2] + 1) {
                int number = nums.get(peek[1]).get(peek[2] + 1);
                max = Math.max(max, number);
                pq.offer(new int[]{number, peek[1], peek[2] + 1});
            }
        }
        return new int[]{start, end};
    }
}