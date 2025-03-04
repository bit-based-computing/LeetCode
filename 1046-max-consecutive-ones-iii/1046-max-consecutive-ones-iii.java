class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        while(r < nums.length) {
            sum += nums[r];
            while(r-l+1-sum > k) {
                sum -= nums[l++];
            }
            if(r - l + 1 > ans) ans = r - l + 1;
            r++;
        }
        return ans;
    }
}