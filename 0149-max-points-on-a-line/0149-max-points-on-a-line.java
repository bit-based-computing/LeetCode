class Solution {
    public int maxPoints(int[][] points) {

        int len = points.length;
        int maxPoint = 0;
        for (int i = 0; i < len; i++) {
            int count = getMaxCounts(i, points);
            maxPoint = Math.max(count, maxPoint);
        }
        return maxPoint;
    }

    public int getMaxCounts(int focalIndex, int[][] points) {

        Map<String, Integer> pointMap = new HashMap<>();
        int maxPoint = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            if (i == focalIndex)
                continue;
            int raise = points[i][1] - points[focalIndex][1];
            int run = points[i][0] - points[focalIndex][0];
            String s = "1_0";
            if (run != 0) {
                int gcd = getGcd(raise, run);
                raise = raise / gcd;
                run = run / gcd;
                s = raise + "_" + run;
            }
            pointMap.put(s, pointMap.getOrDefault(s, 0) + 1);
            maxPoint = Math.max(maxPoint, pointMap.get(s));
        }
        return maxPoint + 1;
    }

    int getGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}