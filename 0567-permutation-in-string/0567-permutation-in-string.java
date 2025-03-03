class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();
        if(s2len < s1len) return false;
        
        int[] s1freq = new int[26];
        int[] s2freq = new int[26];
        for(int i = 0; i < s1len; i++) {
            s1freq[s1.charAt(i) - 'a']++;
            s2freq[s2.charAt(i) - 'a']++;
        }
        for(int i = 0; i <= s2len - s1len; i++) {
            if(Arrays.equals(s1freq, s2freq)) return true;
            if(i + s1len < s2len) {
                s2freq[s2.charAt(i) - 'a']--;
                s2freq[s2.charAt(i + s1len) - 'a']++;
            }
        }
        return false;
    }
}