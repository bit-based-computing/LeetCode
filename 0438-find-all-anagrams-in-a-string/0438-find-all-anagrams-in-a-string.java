class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        if(slen < plen) return ans;
        int[] sfreq = new int[26];
        int[] pfreq = new int[26];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        for(int i = 0; i < plen; i++) {
            pfreq[pc[i] - 'a']++;
            sfreq[sc[i] - 'a']++;
        }
        for(int i = 0; i <= slen - plen; i++) {
            if(Arrays.equals(pfreq, sfreq)) ans.add(i);
            sfreq[sc[i] - 'a']--;
            if(i + plen < slen) {
                sfreq[sc[i+plen] - 'a']++;
            }
        }
        return ans;
    }
}