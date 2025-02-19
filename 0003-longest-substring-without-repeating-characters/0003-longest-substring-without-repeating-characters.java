class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        int count = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.get(ch[i]) == null || map.get(ch[i]) < start) {
                count++;
                map.put(ch[i], i);
            } else {
                ans = Math.max(ans, count);
                start = map.get(ch[i]) + 1;
                count = i - map.get(ch[i]);
                map.put(ch[i], i);
            }
        }
        System.out.println(count);
        return Math.max(ans, count);
    }
}