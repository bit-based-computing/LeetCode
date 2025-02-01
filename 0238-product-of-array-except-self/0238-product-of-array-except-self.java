class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        prefix[1] = nums[0];
        suffix[len-2] = nums[len-1];
        for(int i = 2; i < len; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for(int i = len - 3; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        for(int i = 1; i < len - 1; i++) {
            prefix[i] = prefix[i] * suffix[i];
        }
        prefix[0] = suffix[0];
        return prefix;
    }
}