class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int rMin = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for(int i = 0; i < n; i++) {
            rMin = Math.max(rMin, getRMin(i, manager, informTime, dp));
        }
        return rMin;
    }

    int getRMin(int employee, int[] manager, int[] time, int[] dp) {
        if(manager[employee] == -1) return 0;
        if(dp[employee] != -1) return dp[employee];
        dp[employee] = getRMin(manager[employee], manager, time, dp) + time[manager[employee]];
        return dp[employee];
    }
}