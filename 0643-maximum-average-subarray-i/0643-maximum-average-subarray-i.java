class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum +=(double) nums[i];
            if(i >= k) {
                sum -= (double) nums[i-k];
                ans = Math.max(ans, sum / k);
            }
            if(i == k - 1) {
                ans = Math.max(ans, sum / k);
            }
        }
        return ans;
    }
}