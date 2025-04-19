class Solution {
    public double pow(double x, long n) {
        if(n == 0) return 1;
        if(n % 2 == 0) {
           x = pow(x, n/2);
           return x * x;
        } 
        return x * pow(x, n-1);
    }
    public double myPow(double x, int n) {
        long nn = getAbs(n);
        double sum = 1.0;
        while(nn > 0) {
            if(nn % 2 == 0) {
                x = x * x;
                nn = nn / 2;
            } else {
                sum = sum * x;
                nn = nn - 1;
            }
        }
        if(n >= 0) return sum;
        return 1.0/sum;
    }
    public long getAbs(long n) {
        return Math.abs(n);
    }
}