class Solution {

    private int[][] memo;

    public int minDistance(String word1, String word2) {

        int m = word1.length(), n = word2.length();

        memo = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1; // init all values to -1
            }
        }

        return calculateDistance(word1, word2, word1.length(), word2.length());
    }

    private int calculateDistance(String word1, String word2, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (memo[m][n] != -1)
            return memo[m][n];
        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            memo[m][n] = calculateDistance(word1, word2, m - 1, n - 1);
        } else {
            memo[m][n] = 1 + Math.min(calculateDistance(word1, word2, m, n - 1),
                    Math.min(calculateDistance(word1, word2, m - 1, n),
                            calculateDistance(word1, word2, m - 1, n - 1)));
        }

        return memo[m][n];
    }
}