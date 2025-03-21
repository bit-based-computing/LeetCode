class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l <=r ){
            int mid = l + (r - l)/2;
            if(mid - 1 >= 0 && mid + 1 <= r && 
                nums[mid] >= nums[mid-1] && nums[mid] >= nums[mid+1]) return mid;
            if(mid + 1 < nums.length && nums[mid+1] > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}