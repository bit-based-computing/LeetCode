class Solution {
    public int findSum(int[] nums, boolean isMax) {
        int ans = nums[0];
        int sum = 0;
        if(isMax) {
           for(int num: nums) {
                sum += num;
                if(sum > ans) ans = sum;
                if(sum < 0) sum = 0;
           }
        } else {
            for(int num: nums) {
                sum += num;
                if(sum < ans) ans = sum;
                if(sum > 0) sum = 0;
           }
        }
        return ans;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int max = findSum(nums, true);
        int min = findSum(nums, false);
        int total = 0;
        for(int num: nums) total+=num;
        if(max > 0) return Math.max(max, total - min);
        return max;
    }
}