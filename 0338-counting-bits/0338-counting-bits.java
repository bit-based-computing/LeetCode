class Solution {
    public int[] countBits(int n) {
        n++;
        int[] ans = new int[n];
        ans[0] = 0;
        for(int i = 1; i < n; i++) {
            if(i % 2 == 1) ans[i] = 1;
            ans[i] = ans[i/2] + ans[i];
        }
        return ans;
    }
}