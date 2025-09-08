class Solution {
    public long maxPoints(int[][] points) {
        int row = points.length;
        int col = points[0].length;

        long[] dp = new long[col];
        for (int j = 0; j < col; j++) {
            dp[j] = points[0][j];  // first row base
        }

        for (int i = 1; i < row; i++) {
            long[] left = new long[col];
            long[] right = new long[col];
            long[] newDp = new long[col];

            // Left-to-right pass
            left[0] = dp[0];
            for (int j = 1; j < col; j++) {
                left[j] = Math.max(left[j - 1] - 1, dp[j]);
            }

            // Right-to-left pass
            right[col - 1] = dp[col - 1];
            for (int j = col - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, dp[j]);
            }

            // Combine
            for (int j = 0; j < col; j++) {
                newDp[j] = points[i][j] + Math.max(left[j], right[j]);
            }

            dp = newDp;
        }

        long ans = 0;
        for (long x : dp) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}
