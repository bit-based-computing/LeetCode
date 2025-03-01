class Solution {
    public int findMaxLength(int[] nums) {
        int[] count = new int[2];
        int min = 0;
        int ans = 0;
        count[nums[0]]++;
        for(int i = 1; i < nums.length; i++) {
                count[nums[i]]++;
                nums[i] = nums[i] + nums[i-1];
        }
        min = Math.min(count[0], count[1]);
        int maxLen = min * 2;
        while(maxLen > 0) {
            if(nums[maxLen-1] == maxLen/2) return maxLen;
            for(int i = maxLen; i < nums.length; i++) {
                int sum = nums[i] - nums[i-maxLen];
                if(sum == maxLen/2) return maxLen;
            }
            maxLen = maxLen - 2;
        }
        return 0;
    }
}