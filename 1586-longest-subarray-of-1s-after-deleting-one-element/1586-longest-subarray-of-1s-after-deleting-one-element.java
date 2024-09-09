class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(nums[i] == 0) {
                    list.add(sum);
                    sum = 0;
            }
        }
        list.add(sum);
        if(sum > ans) ans = sum;
        for(int i = 1; i < list.size(); i++) {
           sum = list.get(i) + list.get(i-1);
            if(sum > ans) {
                ans = sum;
            }
        }
        if(ans == nums.length) ans--;
        return ans;
    }
}