class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < len; i++) {
            int x = Math.abs(nums[i]);
            if (x != 0) {
                x--;
                if (x < len && nums[x] >= 0) {
                    if(nums[x] == 0) nums[x] = -(x+1);
                    else nums[x] = -1 * nums[x];
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0)
                return i + 1;
        }
        return len + 1;
    }
}