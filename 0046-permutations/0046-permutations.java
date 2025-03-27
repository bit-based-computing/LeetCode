class Solution {
    void generate(int[] nums, int count, List<Integer> list, List<List<Integer>> ans) {
        if (count == nums.length) {
            List<Integer> nList = new ArrayList<>();
            nList.addAll(list);
            ans.add(nList);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x != 11) {
                nums[i] = 11;
                list.add(x);
                generate(nums, count + 1, list, ans);
                list.remove(list.size()-1);
                nums[i] = x;
            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums, 0, new ArrayList<Integer>(),  ans);
        return ans;
    }
}