class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] ans = new int[2];
        while(l < r) {
            if(nums[l] + nums[r] == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            }
            if(nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}