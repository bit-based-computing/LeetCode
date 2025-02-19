class Solution {

    public String sort(String s) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        return new String(ca);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            String sorted = sort(s);
            if(map.get(sorted) == null) map.put(sorted, new ArrayList<String>());
            map.get(sorted).add(s);
        }
        for(List<String> value: map.values()) {
            ans.add(value);
        }
        return ans;
    }
}