class Solution {

    void swap(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        swap(nums, 0, len-1);
        swap(nums, 0, k-1);
        swap(nums, k, len-1);
    }
}