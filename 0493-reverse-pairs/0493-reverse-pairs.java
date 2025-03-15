class Solution {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int mid = 0;
        return divide(l, r, nums);
    }

    public int divide(int l, int r, int[] nums) {
        if (l == r)
            return 0;
        int count = 0;
        int mid = l + ((r - l) / 2);
        count = divide(l, mid, nums);
        count += divide(mid + 1, r, nums);
        count += countPairs(l, r, mid, nums);
        merge(l, r, mid, nums);
        return count;
    }

    public int countPairs(int l, int r, int mid, int[] nums) {
        int count = 0;
        int j = mid + 1;
        for(int i = l; i <= mid; i++) {
            while(j <= r && nums[i] > 2L * nums[j]) {
                j++;
            }
            count =  count + j - 1 - mid;
        }
        return count;
    }

    public void merge(int l, int r, int mid, int[] nums) {
        int i = l;
        int j = mid + 1;
        int[] temp = new int[r - l + 1];
        int k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= r) {
            temp[k++] = nums[j++];
        }
        for (i = l; i <= r; i++) {
            nums[i] = temp[i - l];
        }
    }
}