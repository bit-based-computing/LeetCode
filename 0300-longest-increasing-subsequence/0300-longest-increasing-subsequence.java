class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        Integer[][] dp = new Integer[len][len + 1]; 
        return getAns(-1, 0, nums, dp);
    }

    public int getAns(int prevIndex, int index, int[] nums, Integer[][] dp) {
        if (index >= nums.length) return 0;

        if (dp[index][prevIndex + 1] != null) return dp[index][prevIndex + 1];

        int notTake = getAns(prevIndex, index + 1, nums, dp);

        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + getAns(index, index + 1, nums, dp);
        }

        dp[index][prevIndex + 1] = Math.max(take, notTake);
        return dp[index][prevIndex + 1];
    }
}
