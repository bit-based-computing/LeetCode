class Solution {
    public int longestSubarray(int[] nums) {
        int psum = 0;
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(nums[i] == 0) {
                  if(psum + sum > ans) ans = psum + sum;
                  psum = sum;
                  sum = 0;
            }
        }
        sum = psum + sum;
        if(sum > ans) ans = sum; 
        if(ans == nums.length) return ans - 1;
        return ans;
    }
}