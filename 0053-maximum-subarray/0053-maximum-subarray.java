class Solution {
    public int maxSubArray(int[] nums) {
        int max = -100001;
		int sum = 0;
		boolean isAllNegative = true;
		for(int i=0; i<nums.length; i++){
			sum += nums[i];
			if(sum > max) max = sum;
			if(sum < 0) sum = 0;
			if(nums[i] > 0) isAllNegative = false;
		}
		if(sum > max && !isAllNegative) max = sum;
		return max;
    }
}