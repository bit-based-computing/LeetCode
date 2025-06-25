class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) sum += nums[i];
        if(sum % 2 == 1) return false;
        int k = sum / 2;
        int[][] dp = new int[nums.length][k+1];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j <= k; j++) dp[i][j] = -1;
        }
        return isPossible(0, k, nums, dp);
    }

    public boolean isPossible(int index, int k, int[] nums, int[][] dp) {
        if(index >= nums.length) return false;
        if(k == 0) return true;
        if(dp[index][k] == 0) return false; 
        if(k - nums[index] >= 0) {
            if(isPossible(index + 1, k - nums[index], nums, dp)) return true;
            dp[index][k] = 0;
        }
        dp[index][k] = isPossible(index + 1, k, nums, dp) ? 1 : 0;
        return dp[index][k] == 1;
    }
}