class Solution {
    void generate(int index, int target, List<Integer> list, int[] nums, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            if(nums[i] > target) break;
            if(i > index && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            generate(i+1, target-nums[i], list, nums, ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        generate(0, target, new ArrayList<Integer>(), candidates, ans);
        return ans;
    }
}