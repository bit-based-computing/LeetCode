class Solution {
    public int maxVowels(String s, int k) {
        k--;
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i > k) {
                char c = s.charAt(i-k-1);
                if(isVowle(c)) count--;
            }
            char c = s.charAt(i);
            if(isVowle(c)) {
                count++;
            }
            if(count > maxCount) maxCount = count;
        }
        return maxCount;
    }

    private boolean isVowle(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}