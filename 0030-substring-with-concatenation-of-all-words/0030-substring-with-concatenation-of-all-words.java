class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int lens = s.length();
        int lenw = words[0].length();
        int lenws = words.length * lenw;
        if(lens < lenws) return ans;
        Map<String, Integer> counts = new HashMap<>();
        for(String word: words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        for(int i = 0 ; i <= lens - lenws; i++) {
            String sub = s.substring(i, i + lenws);
            if(isConcat(sub, counts, lenw)) {
                ans.add(i);
            }
        }
        return ans;
    }

    boolean isConcat(String s, Map<String, Integer> counts, int lenw) {
        Map<String, Integer> seen = new HashMap<>();
        for(int i = 0; i < s.length(); i+=lenw) {
             String sub = s.substring(i, i + lenw);
             seen.put(sub, seen.getOrDefault(sub, 0) + 1);
        }
        return counts.equals(seen);
    }
}