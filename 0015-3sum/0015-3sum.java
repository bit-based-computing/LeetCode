class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int l = i+1;
            int r = len - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                   ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                   l++;
                   r--;
                   while (l < r && nums[l] == nums[l-1]) l++;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }                   
            }
        }
        return ans;
    }
}