class Solution {
    boolean isValid(int[] piles, long k, long h) {
        long count = 0;
        for(long pile: piles) {
            count = count + (pile/k);
            if(pile % k != 0) count++;
        }
        return count <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        long max = 0;
        for(long pile: piles){
            if(pile > max) max = pile;
        }
        long ans = 0;
        long l = 1;
        long r = max;
        while(l <= r) {
            long mid = l + (r - l)/2;
            if(isValid(piles, (int)mid, h)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;
    }
}