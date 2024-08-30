class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int m = l + 1;
        int[] rmax = new int[len];
        int lmin = nums[0];
        rmax[len-1] = nums[len-1];
        for(int i = len-2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i+1], nums[i+1]);
        }
        for(int i = 1; i < len -1; i++) {
            lmin = Math.min(lmin, nums[i-1]);
            if(lmin < nums[i] && nums[i] < rmax[i]) return true;
        }
        return false;
    }
}