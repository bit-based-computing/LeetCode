class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int ans = nums.length + 1;
        int minLength;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= target) {
                minLength = i - start + 1;
                if(minLength < ans) ans = minLength;
                sum -= nums[start++];
            }
        }
        if(ans > nums.length) return 0;
        return ans;
    }
}