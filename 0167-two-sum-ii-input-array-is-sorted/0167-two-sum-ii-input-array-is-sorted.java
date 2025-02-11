class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] ans = new int[2];
        int sum = 0;
        while (l < r) {
            sum = nums[l] + nums[r];
            if (sum == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}