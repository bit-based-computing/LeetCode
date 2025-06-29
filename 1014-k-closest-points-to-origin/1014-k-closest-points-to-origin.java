class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<double[]> pq = new PriorityQueue<>((double[] a, double[] b) -> Double.compare(b[0], a[0]));
        for(int[] point: points) {
            double x = point[0];
            double y = point[1];

            x = x * x;
            y = y * y;
            double dist = Math.sqrt(x + y);
            pq.add(new double[]{dist, point[0], point[1]});
            if(pq.size() > k) pq.poll();
        }

        int[][] results = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()) {
            double[] sp = pq.poll();
            results[i][0] = (int)sp[1];
            results[i][1] = (int)sp[2];
            i++;
        }
        return results;
    }
}