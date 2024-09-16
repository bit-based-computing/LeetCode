class Solution {
    public int tribonacci(int n) {
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        if(n == 0) return t0;
        if(n == 1) return t1;
        if(n == 2) return t2;
        int temp1 = t1;
        int temp2 = t2;
        for(int i = 3; i <= n; i++) {
            temp1 = t1;
            temp2 = t2;
            t2 = t2 + t1 + t0;
            t1 = temp2;
            t0 = temp1;
        }

        return t2;
    }
}