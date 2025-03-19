class Solution {
    public int maximumGap(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i+1] - nums[i] > ans) {
                ans = nums[i+1] - nums[i];
            }
        }
        return ans;
    }
}