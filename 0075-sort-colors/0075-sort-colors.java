class Solution {
    void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public void sortColors(int[] nums) {
        int l = 0;
        int mid = 0;
        int r = nums.length - 1;
        while (l <= r && mid <= r) {
            if (nums[mid] == 2) {
                swap(mid, r, nums);
                r--;
            }
            if (nums[mid] == 0) {
                swap(mid, l, nums);
                l++;
            }
            if (nums[mid] == 1) {
                mid++;
            }
            if(mid < l) mid = l;
        }
    }
}