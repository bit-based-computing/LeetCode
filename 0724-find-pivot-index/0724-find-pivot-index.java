class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int ans = -1;
        int[] prefix = new int[len];
        prefix[0] = 0;
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        if (prefix[len - 1] == 0)
            ans = len - 1;
        int sum = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (sum == prefix[i])
                ans = i;
            sum += nums[i];
        }
        return ans;
    }
}