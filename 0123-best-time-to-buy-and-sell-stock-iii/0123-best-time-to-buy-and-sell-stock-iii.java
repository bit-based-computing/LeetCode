class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        
        int n = prices.length;
        int[][] dp = new int[n][5];
        
        // Initial state assignment
        dp[0][0] = 0;                // No action
        dp[0][1] = -prices[0];       // Buy first stock
        dp[0][2] = 0;                // After first sell
        dp[0][3] = -prices[0];       // Buy second stock
        dp[0][4] = 0;                // After second sell

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }
        
        // The answer will be in state 4, with highest profit after second sell
        return dp[n-1][4];
    }
}