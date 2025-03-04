class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int max = values[0];
        for(int i = 1; i < values.length; i++) {
            max--;
            if(max + values[i] > ans) ans = max + values[i];
            if(values[i] > max) max = values[i];
        }
        return ans;
    }
}