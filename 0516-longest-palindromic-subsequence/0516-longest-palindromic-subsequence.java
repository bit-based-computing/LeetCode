class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len+1][len+1];

        for(int i = 0; i < len; i++) dp[i][i] = 1;

        for(int k = 2; k <= len; k++) {
            for(int i = 0; i <= len - k; i++) {
                int j = i + k - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2;
                    if(k != 2) dp[i][j] += dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}