class Solution {
    public double pow(double x, long n) {
        if(n == 0) return 1;
        if(n % 2 == 0) {
           return pow(x*x, n/2);
        } 
        return x * pow(x, n-1);
    }
    public double myPow(double x, int n) {
        long nn = getAbs(n);
        System.out.println(nn);
        double ans = pow(x, nn);
        if(n < 0) return 1/ ans;
        return ans;
    }
    public long getAbs(long n) {
        return Math.abs(n);
    }
}