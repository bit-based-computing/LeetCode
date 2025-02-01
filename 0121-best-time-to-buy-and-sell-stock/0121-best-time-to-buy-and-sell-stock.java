class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        int len = prices.length;
        for(int i = 1; i < len; i++) {
            if(prices[i] > buy) {
                profit = Math.max(profit, prices[i] - buy);
            } else {
                buy = prices[i];
            }
        }
        return profit;
    }
}