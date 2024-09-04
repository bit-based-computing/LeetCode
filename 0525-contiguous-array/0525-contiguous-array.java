class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        int len = nums.length;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + (nums[i] == 0 ? -1 : 1);
            if(sum == 0) ans = i + 1;
            else if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}