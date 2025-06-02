class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int[] a: intervals) {
            list.add(a);
        }
        list.add(newInterval);
        list.sort((int[] a , int[] b)-> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        List<int[]> merge = new ArrayList<>();

        int[] current = list.get(0);
        for(int[] a: list) {
            if(a[0] <= current[1]) {
                current[1] = Math.max(a[1], current[1]);
            } else {
                merge.add(current);
                current = a;
            }
        }

        merge.add(current);

        return merge.toArray(new int[merge.size()][2]);

    }
}