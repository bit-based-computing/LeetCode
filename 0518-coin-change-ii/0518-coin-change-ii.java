class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len][5001];
        for(int[] x: dp) Arrays.fill(x, -1);
        return way(0, coins, amount, dp);
    }

    int way(int index, int[] coins, int amount, int[][] dp) {
        
        if(amount == 0) return 1;
        if(index >= coins.length) return 0;
        if(dp[index][amount] != -1) return dp[index][amount];
        
        int x = 0;
        int curAmount = amount;
        while(curAmount - coins[index] >= 0) {
            curAmount -= coins[index]; 
            x += way(index + 1, coins, curAmount, dp);
        }
        x += way(index + 1, coins, amount, dp);
        dp[index][amount] = x;
        return x;
    } 
}