class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while(l <= r) {
            mid = l + (r-l)/2;
            if(nums[mid] < min) min = nums[mid];
            if(nums[l] <= nums[mid]) {
                if(nums[l] < min) min = nums[l];
                l = mid + 1;
            } else {
                if(mid+1 < r && nums[mid+1] < min) mid = nums[mid+1];
                r = mid - 1;
            }
        }
        return min;
    }
}