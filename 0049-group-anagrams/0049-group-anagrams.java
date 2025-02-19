class Solution {

    public String sort(String s) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        return new String(ca);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String s = strs[i];
            String sorted = sort(s);
            List<String> ls = map.getOrDefault(sorted, new ArrayList<String>());
            ls.add(s);
            map.put(sorted, ls);
        }
        for(List<String> value: map.values()) {
            ans.add(value);
        }
        return ans;
    }
}