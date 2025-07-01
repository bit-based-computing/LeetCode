class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        for(int[] x: dp) Arrays.fill(x, -1);
        return way(0, 0, nums, target, dp);
    }

    int way(int sum, int index, int[] nums, int target, int[][] dp) {
        if(index > nums.length) return 0;
        if(index == nums.length){
            if(sum == target) return 1;
            return 0;
        }
        int dpIndex = sum > 0 ? sum : 1000 + Math.abs(sum);
        if(dp[index][dpIndex] != -1) return dp[index][dpIndex];
        dp[index][dpIndex] = way(sum + nums[index], index + 1, nums, target, dp) + way(sum - nums[index], index + 1, nums, target, dp);
        return dp[index][dpIndex];
    }
}