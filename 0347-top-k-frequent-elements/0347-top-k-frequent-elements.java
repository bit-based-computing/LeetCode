class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> treeMap = new TreeMap<>(Collections.reverseOrder());
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num: map.keySet()) {
            int x = map.get(num);
            if(treeMap.get(x) == null) treeMap.put(x, new ArrayList<Integer>());
            treeMap.get(x).add(num);
        }
        int[] ans = new int[k];
        int i = 0;
        for(int key: treeMap.keySet()) {
            for(int num: treeMap.get(key)) {
                ans[i++] = num;
                if(i == k) break;
            }
            if(i == k) break;
        }
        return ans;
    }
}