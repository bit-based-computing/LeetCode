class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(pair -> nums1[pair[0]] + nums2[pair[1]])
        );

        // Only push the first k pairs from nums1 with nums2[0]
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{i, 0});  // Pair of indices [i, 0]
        }

        while(k > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int i = pair[0];
            int j = pair[1];
            result.add(List.of(nums1[i], nums2[j]));
            if(j+1 < nums2.length) {
                minHeap.offer(new int[]{i, j+1});
            }
            k--;
        }
        return result;
    }
}