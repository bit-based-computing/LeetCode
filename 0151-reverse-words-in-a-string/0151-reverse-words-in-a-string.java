class Solution {
    void reverse(char[] sc, int start, int end) {
        while (start < end) {
            char temp = sc[start];
            sc[start] = sc[end];
            sc[end] = temp;
            start++;
            end--;
        }

    }

    public String reverseWords(String s) {
        s = s.trim();
        int slen = s.length();
        char[] sc = s.toCharArray();
        reverse(sc, 0, slen-1);

        int l = 0;
        int r = l;
        while (l < slen) {
            while (r < slen && sc[r] != ' ') {
                r++;
            }
            reverse(sc, l, r - 1);
            l = r + 1;
            while(r < slen && sc[r] == ' ') {
                r++;
            }
        }
        l = 0;
        r = 0;
        while(r < slen) {
            while(r < slen && sc[r] != ' ') {
                sc[l] = sc[r];
                if(r > l) sc[r] = ' ';
                l++;
                r++;
            }
            l = l + 1;
            r = l;
            while(r < slen && sc[r] == ' ') {
                r++;
            }
        }

        String ans = new String(sc);
        return ans.trim();

    }
}