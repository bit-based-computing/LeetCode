class Solution {
    void generate(int index, int target, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        if(target == 0) {
            List<Integer> nlist = new ArrayList<>();
            nlist.addAll(list);
            ans.add(nlist);
            return;
        }
        if(index < nums.length) {
            if(nums[index] <= target) {
                list.add(nums[index]);
                generate(index, target - nums[index], nums, list, ans);
                list.remove(list.size()-1);
            }
            generate(index+1, target, nums, list, ans);
        }
       
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }
}