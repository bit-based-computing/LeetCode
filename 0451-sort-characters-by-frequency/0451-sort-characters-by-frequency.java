class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[92];
        char[] cs = s.toCharArray();
        int index = 0;
        for (char c : cs) {
            index = c - '0';
            freq[index]++;
        }
        StringBuilder sb = new StringBuilder();
        int max = 0;
        while (true) {
            max = 0;
            for (int i = 0; i < 92; i++) {
                if (freq[i] > max) {
                    max = freq[i];
                    index = i;
                }
            }
            if (max == 0) break;
            freq[index] = 0;
            for (int i = 0; i < max; i++) {
                sb.append((char) ('0' + index));
            }
        }
        return sb.toString();
    }
}