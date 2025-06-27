class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return getlcs(text1, text2, row, col, dp);
    }

    public int getlcs(String text1, String text2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        int max = 0;
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            max = 1 + getlcs(text1, text2, m - 1, n - 1, dp);
        } else {
            max = Math.max(getlcs(text1, text2, m - 1, n, dp), getlcs(text1, text2, m, n - 1, dp));
        }
        dp[m][n] = max;
        return max;
    }
}