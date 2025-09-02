class Solution {
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for(int stone: stones) {
            sum += stone;
        }

        int half = sum / 2;

        boolean[] dp = new boolean[half + 1];

        dp[0] = true;
        for(int i = 0; i < len; i++) {
            int num = stones[i];
            for(int j = half; j >= num; j--) {
                if(dp[j-num]) {
                    dp[j] = true;
                }
            }
        }
        for(int j = half; j >= 0; j--) {
            if(dp[j]) {
                return sum - (j * 2);
            }
        }
        return 0; 
    }
}