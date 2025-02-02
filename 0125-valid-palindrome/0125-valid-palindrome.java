class Solution {

    public boolean isAlphanumeric(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (isAlphanumeric(array[i])) {
                sb.append(array[i]);
            }
        }
        String ns = sb.toString();
        String rs = sb.reverse().toString();
        return ns.equals(rs);

    }
}