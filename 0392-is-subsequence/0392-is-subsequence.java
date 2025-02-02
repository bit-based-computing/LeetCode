class Solution {
    public boolean isSubsequence(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if(lens > lent) return false;
        int j = 0;
        for(int i = 0; i < lent; i++) {
            if(j == lens) return true;
            if(t.charAt(i) == s.charAt(j))
                j++;
        }
        if(j == lens) return true;
        return false;
    }
}