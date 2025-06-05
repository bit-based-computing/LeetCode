class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (int[] a, int[] b) -> {
           return Integer.compare(a[1], b[1]);
        });

        // for(int[] a: intervals) {
        //     System.out.println(a[0] + " " + a[1]);
        // }
        
        int[] current = intervals[0];
        int count = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(current[1] > intervals[i][0]) {
                count++;
            } else {
               current = intervals[i];
            }
        }
        return count;
    }
}