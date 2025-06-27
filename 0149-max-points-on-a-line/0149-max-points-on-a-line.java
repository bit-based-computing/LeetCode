class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len <= 2)
            return len;

        int max = 2;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int count = 2;
                for (int k = 0; k < len; k++) {
                    if (k == i || k == j)
                        continue;

                    boolean isInSameLine = ((points[j][0] - points[i][0])
                            * (points[k][1] - points[i][1])) == ((points[j][1] - points[i][1])
                                    * (points[k][0] - points[i][0]));

                    if (isInSameLine)
                        count++;
                }
               max = Math.max(max, count);
            }
        }

        return max;
    }
}