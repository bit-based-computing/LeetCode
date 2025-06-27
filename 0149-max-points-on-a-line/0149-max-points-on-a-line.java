class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len <= 2)
            return len;
        int max = 0;

        for (int i = 0; i < len; i++) {
            Map<String, Integer> slopes = new HashMap<>();
            int duplicate = 1;
            int cMax = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;

                int y = points[j][1] - points[i][1];
                int x = points[j][0] - points[i][0];
                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;
                }
                int commonDivisor = gcd(x, y);
                x = x / commonDivisor;
                y = y / commonDivisor;

                String s = y + "/" + x;
                slopes.put(s, slopes.getOrDefault(s, 0) + 1);
                cMax = Math.max(cMax, slopes.get(s));
            }
            
            max = Math.max(max, cMax + duplicate);
        }
        return max;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}