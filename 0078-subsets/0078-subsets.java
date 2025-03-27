class Solution {
    void generate(int index, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        if(index >= nums.length) {
            if(list.size() > 0){
                List<Integer> nlist = new ArrayList<Integer>();
                nlist.addAll(list);
                ans.add(nlist);
            }
            return;
        }
        list.add(nums[index]);
        generate(index+1, nums, list, ans);
        list.remove(list.size()-1);
        generate(index+1, nums,list, ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(0, nums, new ArrayList<Integer>(), ans);
        ans.add(new ArrayList<Integer>());
        return ans;
    }
}