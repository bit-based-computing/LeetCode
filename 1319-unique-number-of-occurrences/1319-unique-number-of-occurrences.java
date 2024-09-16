class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        Set<Integer> s = new HashSet<>();

        for(Integer value : map.values()) {
            if(!s.contains(value)) s.add(value);
            else return false;
        }
        return true;
    }
}