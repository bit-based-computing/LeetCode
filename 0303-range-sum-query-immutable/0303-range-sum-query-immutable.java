class NumArray {
    int [] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int ans = sums[right];
        if(left > 0) ans -= sums[left-1];
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */