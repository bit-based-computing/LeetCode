class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return way(0, dp, n);
    }

    int way(int currPos, int[] dp, int n) {
        if(currPos > n) return 0;
        if(currPos == n) return 1;
        if(dp[currPos] != -1) return dp[currPos];
        dp[currPos] = way(currPos + 1, dp, n) + way(currPos + 2, dp, n);
        return dp[currPos];
    }
}