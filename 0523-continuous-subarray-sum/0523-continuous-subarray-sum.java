class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int rem = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rem = sum % k;
            if(rem == 0 && i > 0) return true;
            if(map.get(rem) == null) map.put(rem, i);
            else if(i - map.get(rem) > 1) return true;
        }
        return false;
    }
}