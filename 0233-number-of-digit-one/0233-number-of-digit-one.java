class Solution {
    int[] digits;
    Integer[][][] dp;

    public int countDigitOne(int n) {
        digits = String.valueOf(n).chars().map(c -> c - '0').toArray();
        dp = new Integer[11][2][11];
        return dfs(0, 1, 0);
    }

    public int dfs(int indx, int isTight, int cnt_of_1) {
        if (indx >= digits.length)
            return cnt_of_1;

        int up = isTight == 1 ? digits[indx] : 9;

        if (dp[indx][isTight][cnt_of_1] != null) {
            return dp[indx][isTight][cnt_of_1];
        }

        int count = 0;
        for (int i = 0; i <= up; i++) {
            count += dfs(indx + 1,
                    isTight == 1 && i == up ? 1 : 0,
                    i == 1 ? cnt_of_1 + 1 : cnt_of_1);
        }
        return dp[indx][isTight][cnt_of_1] = count;
    }
}