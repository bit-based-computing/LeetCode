class Solution {

    Integer[][][] dp;
    String s;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        s = String.valueOf(n);
        int len = s.length();
        dp = new Integer[len][2][2];
        return dfs(0, 1, 0, digits);    
    }

    int dfs(int indx, int tight, int isStart, String[] digits) {
        if(indx >= s.length()){
            return isStart == 1 ? 1 : 0;
        }

        if(dp[indx][tight][isStart] != null)
            return dp[indx][tight][isStart];

        int count = 0;
        if(isStart == 0) {
            count += dfs(indx + 1, 0, 0, digits);
        }
        int limit = tight == 1 ? s.charAt(indx) - '0' : 9;
        for(int i = 0; i < digits.length; i++){
            String d = digits[i];
            int number = d.charAt(0) - '0';
            if(tight == 1 && number > limit) continue;
            int nextTight = tight == 1 && number == limit ? 1 : 0;
            count += dfs(indx + 1, nextTight, 1, digits);
        }
        return dp[indx][tight][isStart] = count;
    }
}