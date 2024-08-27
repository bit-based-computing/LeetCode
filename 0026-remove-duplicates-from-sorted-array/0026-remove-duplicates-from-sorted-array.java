class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = l + 1;
        while (r < len) {
            if(nums[r] == nums[l]) r++;
            else {
                nums[l+1] = nums[r];
                l++;
                r++;
            }
        }
        return l + 1;
    }
}