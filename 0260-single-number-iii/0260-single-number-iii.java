class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for(int num: nums) {
            if(sets.contains(num)) {
                sets.remove(num);
            } else {
                sets.add(num);
            }
        }
        int[] ans = new int[2];
        int i = 0;
        for(int num: sets){
            ans[i++] = num;
        }
        return ans;
    }
}