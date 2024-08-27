class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int l = 0;
        int r = len - 1;
        int k = len - 1;
       while (l <= r) {
            if (Math.abs(nums[l]) <= Math.abs(nums[r])) {
                ans[k--] = nums[r] * nums[r];
                r--;
            } else {
                ans[k--] = nums[l] * nums[l];
                l++;
            }
       }
        return ans;
    }
}