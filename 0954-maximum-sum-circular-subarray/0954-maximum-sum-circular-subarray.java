class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int mostNegative = 0;
        int ans = nums[0];
        int sum = 0;
        int negativeSum = 0;
        int allSum = 0;
        boolean isAllNegative = true;
        for(int num: nums) {
            allSum += num;
            sum += num;
            negativeSum = negativeSum + num;
            if(sum > ans) ans = sum;
            if(negativeSum < mostNegative) mostNegative = negativeSum;
            if(sum < 0) sum = 0;
            if(negativeSum > 0) negativeSum = 0;
            if(num > 0) isAllNegative = false;
        }
        if(isAllNegative) return ans;
        return Math.max(ans, allSum - mostNegative);
    }
}