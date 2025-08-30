class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int refuel = 0, i = 0;
        long fuel = startFuel; 
        
        while (fuel < target) {
            while (i < stations.length && stations[i][0] <= fuel) {
                pq.offer(stations[i][1]);
                i++;
            }
            
            if (pq.isEmpty()) return -1;
            
            fuel += pq.poll();
            refuel++;
        }
        
        return refuel;
    }
}
