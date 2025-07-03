class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        int len  = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= len; i++) {
            char first = s.charAt(i-2);
            char second = s.charAt(i-1);

            if(second != '0') {
                dp[i] = dp[i] + dp[i-1];
            }
            int num = ((first - '0') * 10) + (second - '0');
            if(num >= 10 && num <= 26) {
                dp[i] = dp[i] + dp[i-2];
            }
        }
        return dp[len];
    }
}