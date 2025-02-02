class Solution {
    public boolean isSubsequence(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        int is = 0;
        int it = 0;
        while(is < lens && it < lent) {
            if(s.charAt(is) == t.charAt(it)) is++;
            it++;
        }
        if(is == lens) return true;
        return false;
    }
}