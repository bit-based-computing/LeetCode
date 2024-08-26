class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int ans = len;
        for(int i = 0; i < len; i++) {
           if(citations[i] >= ans ) break;
           ans--;
        }
        return ans;
    }
    
}