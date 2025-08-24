class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double ans = Double.MAX_VALUE;
        List<Pair> workers = new ArrayList<>();
        for(int i = 0; i < quality.length; i++) {
            double ratio = (double)wage[i]/(double)quality[i];
            workers.add(new Pair(ratio, quality[i]));
        }

        workers.sort((a,b)-> Double.compare(a.ratio, b.ratio));

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Integer.compare(b.quality, a.quality));
        int qualitySum = 0;
        for(int i = 0; i < workers.size(); i++) {
            Pair worker = workers.get(i);
            pq.add(worker);
            qualitySum += worker.quality;

            if(pq.size() > k) {
                qualitySum -= pq.poll().quality;
            }

            if(pq.size() == k) {
                ans = Math.min(ans, qualitySum * worker.ratio);
            }
        }
        return ans;
    }
}

public class Pair{
    double ratio;
    int quality;
    public Pair(double ratio, int quality) {
        this.ratio = ratio;
        this.quality = quality;
    }
}