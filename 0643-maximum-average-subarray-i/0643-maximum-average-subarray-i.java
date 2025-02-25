class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double div = k;
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        double average = 0;
        for(int j = k - 1; j < nums.length; j++) {
            average = nums[j];
            if(j - k >= 0) average-=nums[j-k];
            average = average/div;
            if(average > max) max = average;
        }
        return max;
    }
}