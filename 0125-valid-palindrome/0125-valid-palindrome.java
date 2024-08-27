class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        boolean lAlphanumeric = false;
        boolean rAlphanumeric = false;
        while (l < r) {
            lAlphanumeric = isAlphanumeric(chars[l]);
            rAlphanumeric = isAlphanumeric(chars[r]);
            if(lAlphanumeric && rAlphanumeric) {
                if(Character.toLowerCase(chars[l]) != Character.toLowerCase(chars[r]))
                     return false;
                l++;
                r--;
            } else {
                if(!lAlphanumeric) l++;
                if(!rAlphanumeric) r--;
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
         return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') ||
                 (c >= 'A' && c <= 'Z');
    }
}