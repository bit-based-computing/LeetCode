class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int crem = 0;
        int[] rem = new int[k];
        rem[0] = 1;
        for(int num: nums) {
            sum += num;
            crem = sum % k;
            if(crem < 0) crem += k;
            count += rem[crem];
            rem[crem]++;
        }
        return count;
    }
}