class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long countZero = 0;
        long totalSubarray = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
            } else {
                if (countZero > 0) {
                    totalSubarray += ((countZero * (countZero + 1)) / 2);
                    countZero = 0;
                }
            }
        }
        if (countZero > 0) {
            totalSubarray += ((countZero * (countZero + 1)) / 2);
            countZero = 0;
        }
        return totalSubarray;
    }
}