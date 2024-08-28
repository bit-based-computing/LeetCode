class Solution {
    public int majorityElement(int[] nums) {
        int me = 0;
        int count = 0;
        for(int num: nums) {
            if(count > 0 && me != num) count--;
            else {
                me = num;
                count++;
            }
        }
        return me;
    }
}