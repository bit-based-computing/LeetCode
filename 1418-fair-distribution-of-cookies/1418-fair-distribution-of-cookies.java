class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] childBins = new int[k];
        // Initial call with a very large unfairness (Infinity) as the starting point
        return backtrack(cookies, childBins, 0, Integer.MAX_VALUE);
    }

    private int backtrack(int[] cookies, int[] childBins, int index, int minUnfairness) {
        if (index == cookies.length) {
            int currentMax = 0;
            for (int cookieCount : childBins) {
                currentMax = Math.max(currentMax, cookieCount);
            }
            return Math.min(minUnfairness, currentMax);
        }

        for (int i = 0; i < childBins.length; i++) {
            childBins[i] += cookies[index];
            
            // Compute current max unfairness after new assignment
            int currentMax = 0;
            for (int cookieCount : childBins) {
                currentMax = Math.max(currentMax, cookieCount);
            }

            if (currentMax < minUnfairness) {
                minUnfairness = backtrack(cookies, childBins, index + 1, minUnfairness);
            }
            childBins[i] -= cookies[index];
        }
        return minUnfairness;
    }
}