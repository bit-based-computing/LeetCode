class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int len = nums.length - 1;
        int[][] dp1 = new int[len + 1][2]; // Case: first house is taken
        int[][] dp2 = new int[len + 1][2]; // Case: first house is NOT taken

        for (int i = 0; i <= len; i++) {
            dp1[i][0] = dp1[i][1] = -1;
            dp2[i][0] = dp2[i][1] = -1;
        }
        return Math.max(nums[0] + getAns(1, true, nums, len - 1, dp1), getAns(1, false, nums, len, dp2));
    }

    public int getAns(int index, boolean previousTaken, int[] nums, int len, int[][] dp) {
        if (index > len)
            return 0;
        int prev = 1;
        if (previousTaken)
            prev = 0;
        if (dp[index][prev] != -1)
            return dp[index][prev];

        int ans = 0;
        if (previousTaken) {
            ans = getAns(index + 1, false, nums, len, dp);
        } else {
            ans = Math.max(nums[index] + getAns(index + 1, true, nums, len, dp),
                    getAns(index + 1, false, nums, len, dp));
        }
        dp[index][prev] = ans;
        return ans;
    }
}