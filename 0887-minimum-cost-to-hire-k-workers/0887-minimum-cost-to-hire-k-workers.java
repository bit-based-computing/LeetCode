public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        Pair[] workers = new Pair[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Pair((double) wage[i] / quality[i], quality[i]);
        }

        // Sort workers by wage/quality ratio
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));

        double minCost = Double.MAX_VALUE;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        double sumQuality = 0;

        for (Pair worker : workers) {
            maxHeap.add(worker.quality);
            sumQuality += worker.quality;

            // Maintain heap size of K
            if (maxHeap.size() > K) {
                sumQuality -= maxHeap.poll();
            }
            
            if (maxHeap.size() == K) {
                minCost = Math.min(minCost, sumQuality * worker.ratio);
            }
        }

        return minCost;
    }

    private static class Pair {
        double ratio;
        int quality;

        Pair(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }
    }
}