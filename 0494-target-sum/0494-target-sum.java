class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return way(0, 0, nums, target);
    }

    int way(int sum, int index, int[] nums, int target) {
        if(index > nums.length) return 0;
        if(index == nums.length){
            if(sum == target) return 1;
            return 0;
        }
        return way(sum + nums[index], index + 1, nums, target) + way(sum - nums[index], index + 1, nums, target);
    }
}