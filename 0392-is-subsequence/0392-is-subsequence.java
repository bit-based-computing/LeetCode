class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int l = 0;
        int r = 0;
        while(l < slen && r < tlen) {
            if(t.charAt(r) == s.charAt(l)) l++;
            r++;
        }
        if(l == slen) return true;
        return false;
    }
}