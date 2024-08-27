class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int l = 0;
        int r = len - 1;
        int maxH = 0;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(citations[mid] >= len - mid) {
                maxH = len - mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return maxH;
    }
}