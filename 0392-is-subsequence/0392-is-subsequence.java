class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int l = 0;
        int r = 0;
        while(l < slen && r < tlen) {
            if(tchar[r] == schar[l]) l++;
            r++;
        }
        if(l == slen) return true;
        return false;
    }
}