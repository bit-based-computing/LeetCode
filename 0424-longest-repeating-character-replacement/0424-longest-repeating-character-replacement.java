class Solution {
    int getMax(int[] freq) {
        int count = 0;
        for(int num: freq) {
            if(num > count) count = num;
        }
        return count;
    }
    void setZero(int[] freq) {
        for(int i = 0; i < 26; i++) freq[i] = 0;
    }
    public int characterReplacement(String s, int k) {
        char[] sc = s.toCharArray();
        int[] freq = new int[26];
        int max = 0;
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            index = sc[i] - 'A';
            freq[index]++;
            if(freq[index] > max) max = freq[index];
        }
        int window = Math.min(max + k, s.length());
        int min = Integer.MAX_VALUE;
        while(window > 0) {
            setZero(freq);
            for(int i = 0; i < window; i++) {
                index = sc[i] - 'A';
                freq[index]++;
            }
            max = getMax(freq);
            if(window - max <= k) return window;
            if(window - max - k < min) min = window - max - k;
            for(int i = window; i < s.length(); i++) {
                index = sc[i] - 'A';
                freq[index]++;
                index = sc[i-window] - 'A';
                freq[index]--;
                max = getMax(freq);
                if(window - max <= k) return window;
                if(window - max - k < min) min = window - max - k;
            }
            window = window - min;
        }
        return 1;
    }
}