class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len =  cost.length;
        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        return Math.min(find(0, cost, dp), find(1, cost, dp));
    }

    int find(int index, int[] cost, int[] dp) {
        if(index >= cost.length) return 0;
        if(dp[index] != -1) return dp[index];
        dp[index] = cost[index] + Math.min(find(index + 1, cost, dp), find(index + 2, cost, dp));
        return dp[index];
    }
}