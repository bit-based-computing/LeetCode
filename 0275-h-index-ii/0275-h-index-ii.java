class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int l = 0;
        int r = citations[len - 1];
        int maxH = 0;
        while (l <= r) {
            int mid = l + (r-l)/2;
            int bound = getUpperBound(0, len-1, mid, citations);
            if(len - bound >= mid) {
                maxH = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return maxH;
       
    }
    private int getUpperBound(int l, int r, int num, int[] citations) {
        while(l < r) {
            int mid = l + (r - l)/2;
            if(citations[mid] < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}