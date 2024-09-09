class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int zeroCount = 0;
        while( r < nums.length) {
            if(nums[r] == 0) {
                zeroCount++;
            }
            r++;
            if(zeroCount > k) {
                if(nums[l] == 0)
                    zeroCount--;
                l++;
            }          
        }
        return r - l;
    }
}