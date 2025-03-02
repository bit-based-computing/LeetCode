class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int lens = s.length();
        int lenp = p.length();
        int sum = lenp;
        int[] freq = new int[26];
        for (int i = 0; i < lenp; i++)
            freq[p.charAt(i) - 'a']++;

        for (int i = 0; i < 26; i++)
            if (freq[i] == 0)
                freq[i] = -1;
        int wsize = lenp - 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i - start > wsize) {
                if (freq[s.charAt(start) - 'a'] >= 0) {
                    freq[s.charAt(start) - 'a']++;
                    sum++;
                }
                start++;
            }
            if (freq[s.charAt(i) - 'a'] > 0) {
                freq[s.charAt(i) - 'a']--;
                sum--;
            } else if (freq[s.charAt(i) - 'a'] == 0) {
                while (s.charAt(start) != s.charAt(i)) {
                    if (freq[s.charAt(start) - 'a'] >= 0) {
                        freq[s.charAt(start) - 'a']++;
                        sum++;
                    }
                    start++;
                }
                start++;
            }
            if (sum == 0)
                ans.add(start);
        }
        return ans;
    }
}