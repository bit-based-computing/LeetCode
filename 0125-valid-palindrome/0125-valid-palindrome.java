class Solution {
    public boolean isPalindrome(String s) {
        char[] sArray = s.toCharArray();
        int k = 0;
        for(int i = 0; i < s.length(); i++) {
            if(Character.isAlphabetic(sArray[i]) || Character.isDigit(sArray[i])) {
                sArray[k++] = Character.toLowerCase(sArray[i]);
            }
        }
        int l = 0;
        int r = k - 1;
        while (l < r) {
            if(sArray[l] != sArray[r]) return false;
            l++;
            r--;
        }

        return true;

    }
}