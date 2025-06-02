class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int len = intervals.length;
        int i = 0;
        while (i < len) {

            if (intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = intervals[i];
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
            i++;
        }

        list.add(newInterval);

        return list.toArray(new int[list.size()][2]);

    }
}