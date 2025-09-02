class Solution {
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for(int stone: stones) {
            sum += stone;
        }

        int half = sum / 2;

        boolean[][] dp = new boolean[len + 1][half + 1];

        dp[0][0] = true;
        for(int i = 1; i <= len; i++) {
            int num = stones[i-1];
            for(int j = 0; j <= half; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= num) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-num];
                }
            }
        }
        for(int j = half; j >= 0; j--) {
            if(dp[len][j]) {
                return sum - (j * 2);
            }
        }
        return 0; 
    }
}