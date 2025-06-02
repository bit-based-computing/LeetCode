class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (int[] a, int[] b) -> Integer.compare(a[1], b[1]));

        int len = points.length;
        int count = 1;
        int end = points[0][1];
        for(int i = 1; i < len; i++) {
            if(points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;        
    }
}