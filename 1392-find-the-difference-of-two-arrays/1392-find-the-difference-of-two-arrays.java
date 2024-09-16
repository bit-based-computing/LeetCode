class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();

        for(int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
     
        for(Integer num: set1) {
            if(!set2.contains((Integer) num)) {
                list1.add(num);
            } else {
                set2.remove((Integer) num);
            }
        }
        List<Integer> list2 = new ArrayList<>(set2);
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}