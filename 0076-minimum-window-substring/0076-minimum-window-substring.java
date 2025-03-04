class Solution {

    boolean isFound(int[] freq) {
        for (int num : freq)
            if (num > 0)
                return false;
        return true;
    }

    public String minWindow(String s, String t) {
        int tlen = t.length();
        int slen = s.length();
        if (slen < tlen)
            return "";
        int[] freq = new int[60];
        int index = 0;
        int l = 0;
        int r = 0;
        int ans = slen + 1;
        int al = 0;
        int ar = 0;
        for (int i = 0; i < tlen; i++) {
            index = t.charAt(i) - 'A';
            freq[index]++;
        }

        while (r < slen) {
            index = s.charAt(r) - 'A';
            freq[index]--;
            while (isFound(freq)) {
                if (r - l + 1 < ans) {
                    ans = r - l + 1;
                    al = l;
                    ar = r;
                }
                index = s.charAt(l++) - 'A';
                freq[index]++;
            }
            r++;
        }
        if (ans > slen)
            return "";
        return s.substring(al, ar + 1);
    }
}