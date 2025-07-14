class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int[] left = new int[len];
        int[] right = new int[len];
        int lmin = prices[0];
        int rmax = prices[len-1];
        left[0] = 0;
        right[len-1] = 0;
        
        for(int i = 1; i < len; i++) {
            lmin = Math.min(lmin, prices[i]);
            left[i] = Math.max(left[i-1], prices[i] - lmin);
        }

        for(int i = len - 2; i >= 0; i--) {
            rmax = Math.max(rmax, prices[i]);
            right[i] = Math.max(right[i+1], rmax - prices[i]);
        }

        int profit = 0 + right[0];
        for(int i = 1; i < len; i++) {
            profit = Math.max(profit, left[i-1] + right[i]);
        }
        return profit;
    }
}