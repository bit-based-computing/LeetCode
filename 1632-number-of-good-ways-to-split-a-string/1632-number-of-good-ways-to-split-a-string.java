class Solution {

    void setZero(int[] freq) {
        for(int i = 0; i < 26; i++) {
            freq[i] = 0;
        }
    }
    public int numSplits(String s) {
        int len = s.length();
        int[] freq = new int[26];
        char[] cs = s.toCharArray();
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int index = 0;
        int count = 1;
        prefix[0] = 1;
        freq[cs[0]-'a'] = 1;
        for(int i = 1; i < len; i++) {
            index = cs[i] - 'a';
            if(freq[index] == 0) count++;
            freq[index]++;
            prefix[i] = count;
        }
        setZero(freq);
        count = 1;
        freq[cs[len-1] - 'a'] = 1;
        suffix[len-1] = 1;
        for(int i = len - 1; i >= 0; i--) {
            index = cs[i] - 'a';
            if(freq[index] == 0) count++;
            freq[index]++;
            suffix[i] = count;
        }

        count = 0;
        for(int i = 0; i < len - 1; i++) {
            if(prefix[i] == suffix[i+1]) count++;
        }

        return count;

    }
}