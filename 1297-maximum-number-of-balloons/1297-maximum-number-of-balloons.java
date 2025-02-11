class Solution {
    public int maxNumberOfBalloons(String text) {
        int len = text.length();
        char[] ctext = text.toCharArray();
        int[] freq = new int[26];
        for(int i = 0; i < len; i++) {
            freq[ctext[i] - 'a']++;
        }
        int b = freq['b'-'a'];
        int a = freq['a'- 'a'];
        int l = freq['l' - 'a']/2;
        int o = freq['o' - 'a']/2;
        int n = freq['n' - 'a'];
        // System.out.println(b + " " + a + " " + l + " " + o + " " + n);
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o,n))));
    }
}