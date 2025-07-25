class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Map<Integer, Integer> map = new HashMap<>();
        List<Double> results = new ArrayList<>();

        int maxHeapSize = 0, minHeapSize = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
                maxHeapSize++;
            } else {
                minHeap.offer(num);
                minHeapSize++;
            }

            // Remove out-of-window element
            if (i >= k) {
                int toRemove = nums[i - k];
                map.put(toRemove, map.getOrDefault(toRemove, 0) + 1);

                if (toRemove <= maxHeap.peek()) {
                    maxHeapSize--;
                } else {
                    minHeapSize--;
                }
            }

            // Balance
            while (maxHeapSize > minHeapSize + 1) {
                int moved = maxHeap.poll();
                prune(maxHeap, map);
                minHeap.offer(moved);
                maxHeapSize--;
                minHeapSize++;
            }

            while (minHeapSize > maxHeapSize) {
                int moved = minHeap.poll();
                prune(minHeap, map);
                maxHeap.offer(moved);
                minHeapSize--;
                maxHeapSize++;
            }

            // Prune both heaps
            prune(maxHeap, map);
            prune(minHeap, map);

            // Add result
            if (i >= k - 1) {
                if (maxHeapSize > minHeapSize) {
                    results.add((double) maxHeap.peek());
                } else {
                    results.add(((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0);
                }
            }
        }

        return results.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public void prune(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (map.containsKey(num)) {
                heap.poll();
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            } else {
                break;
            }
        }
    }
}
