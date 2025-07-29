class Solution {

    int[] prefixSum;
    Random rand;

    public Solution(int[] w) {
        rand = new Random();
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int max = prefixSum[prefixSum.length - 1];
        int randomNum = rand.nextInt(max) + 1; // Random number in [1, max]

        int l = 0;
        int r = prefixSum.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (prefixSum[mid] < randomNum) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; // l is the index corresponding to randomNum
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */