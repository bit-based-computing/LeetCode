class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount+1];
        amounts[0] = 0;
        for(int i = 1; i <= amount; i++) {
            amounts[i] = 10001;
        }
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                    if(amounts[i-coins[j]] + 1 < amounts[i]) {
                        amounts[i] = amounts[i-coins[j]] + 1;
                    }
                }
            }
        }
        return amounts[amount] == 10001 ? -1: amounts[amount];
    }
}