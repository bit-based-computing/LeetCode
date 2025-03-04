class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int ans = 0;
        int r = 0;
        int l = 0;
        int len = s.length();
        int index = 0;
        int maxFreq = 0;
        while(r < len) {
            index = s.charAt(r) - 'A';
            freq[index]++;
            if(freq[index] > maxFreq) maxFreq = freq[index];
            while((r-l+1-maxFreq) > k) {
                index = s.charAt(l++) - 'A';
                freq[index]--;
                for(int i = 0; i < 26; i++) {
                    if(freq[i] > maxFreq) maxFreq = freq[i];
                }
            }
            if((r-l+1) > ans) ans = r-l+1;
            r++;
        }
        return ans;
    }
}