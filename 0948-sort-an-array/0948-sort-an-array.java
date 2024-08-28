class Solution {
    public int[] sortArray(int[] nums) {
        devide(0, nums.length - 1, nums);
        return nums;
    }
    private void devide(int l, int r, int[] nums) {
        if(l == r || l > r) return;
        int mid = l + (r - l)/2;
        devide(l, mid, nums);
        devide(mid + 1, r, nums);
        merge(l, mid, r, nums);
    }

    private void merge(int l, int mid, int r, int[] nums) {
        int i = l;
        int j = mid + 1;
        int[] temp = new int[r - l + 1];
        int k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= r) temp[k++] = nums[j++];
        for (i = l; i <= r; i++) nums[i] = temp[i-l];
    }
}