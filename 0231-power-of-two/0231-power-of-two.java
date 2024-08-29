class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        long x = 1;
        while(x < n) {
            x *= 2;
        }
        return x == n;
    }
}