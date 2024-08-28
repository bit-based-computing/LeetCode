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
                if (nums[l] + nums[r] == -nums[i]) {
                   ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                   l++;
                   r--;
                   while (l < r && nums[l] == nums[l-1]) l++;
                   while(r > l && nums[r] == nums[r+1]) r--;
                } else if (nums[l] + nums[r] > -nums[i]) {
                    r--;
                } else {
                    l++;
                }                   
            }
        }
        return ans;
    }
}