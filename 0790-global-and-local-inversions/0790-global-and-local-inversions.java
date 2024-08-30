class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if(Math.abs(i-nums[i]) > 1) return false;
        }
        return true;
    }

    private int divide(int left, int right, int[] nums) {
        if(left < right) {
            int globalInv = 0;
            int mid = left + (right-left)/2;
            globalInv += divide(left, mid, nums);
            globalInv += divide(mid+1, right, nums);
            
            int[] temp = new int[right - left + 1];
            int i = left;
            int j = mid + 1;
            int k = 0;
            while(i <= mid && j <= right) {
                if (nums[i] <= nums[j]) {
                    temp[k++] = nums[i++];
                } else {
                    globalInv += (mid - i + 1);
                    temp[k++] = nums[j++];
                }
            }
            while (i <= mid) {
                temp[k++] = nums[i++];
            }
            while (j <= right) {
                temp[k++] = nums[j++];
            }
            for(i = left; i <= right; i++) {
                nums[i] = temp[i-left];
            }
            return globalInv;
        }
        return 0;
    }
}