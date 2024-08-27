class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int l = -1;
        for (int i = 0; i < len; i++) {
            if(nums[i] < 0) l = i;
            nums[i] = nums[i] * nums[i];
            
        }
       int[] ans = new int[len];
       int r = l + 1;
       int k = 0;
       while(l >= 0 && r < len) {
            if(nums[l] <= nums[r]) {
                ans[k++] = nums[l--];
            } else {
                ans[k++] = nums[r++];
            }
       }
       while( l >= 0) {
            ans[k++] = nums[l--];
       }
       while (r < len) {
            ans[k++] = nums[r++];
       }
        return ans;
    }
}