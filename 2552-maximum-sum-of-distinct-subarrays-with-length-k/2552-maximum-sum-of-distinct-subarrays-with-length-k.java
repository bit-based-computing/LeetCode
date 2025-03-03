class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        long sum = 0;
        int start = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.getOrDefault(nums[i], 0) > 1) {
                while(nums[start] != nums[i]) {
                    sum -= nums[start];
                    map.put(nums[start], 0);
                    start++;
                }
                sum -= nums[start];
                map.put(nums[start], 1);
                start++;
            }
            if(i - start + 1 == k){
                if(sum > ans) ans = sum;
                sum -= nums[start];
                map.put(nums[start], 0);
                start++;
            }

        }
        return ans;
    }
}