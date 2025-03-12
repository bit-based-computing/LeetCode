class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> want = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer num : nums) {
            if (map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                if(want.getOrDefault(num, 0) > 0) {
                    want.put(num, want.getOrDefault(num, 0 ) - 1);
                    want.put(num + 1, want.getOrDefault(num + 1, 0) + 1);
                }else if (map.getOrDefault(num + 1, 0) > 0 &&
                        map.getOrDefault(num + 2, 0) > 0) {
                    map.put(num + 1, map.get(num + 1) - 1);
                    map.put(num + 2, map.get(num + 2) - 1);
                    want.put(num + 3, want.getOrDefault(num + 3, 0) + 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
