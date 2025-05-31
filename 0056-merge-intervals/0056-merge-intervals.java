class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (int[] a, int[] b) -> {
           return a[0] - b[0];
        });
        
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int[] current = intervals[0];

        for(int[] a: intervals) {
            if(a[0] <= current[1]) {
                current[1] = Math.max(current[1],a[1]);
            } else {
                list.add(a);
                current = a;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}