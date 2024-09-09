class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
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
        if(sum == nums.length) return sum - 1;
        return ans;
    }
}