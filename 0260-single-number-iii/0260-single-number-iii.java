class Solution {
    public int[] singleNumber(int[] nums) {
        int allXor = nums[0];
        for(int i = 1; i < nums.length; i++) {
            allXor ^= nums[i];
        }
        int a = 0;
        int b = 0;
        int rightMostOnBitPosition = 0;
        while(((allXor >> rightMostOnBitPosition) & 1) != 1){
            rightMostOnBitPosition++;
        }

        for(int num: nums) {
            if(((num >> rightMostOnBitPosition) & 1) == 1) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[] {a,b};
    }
}