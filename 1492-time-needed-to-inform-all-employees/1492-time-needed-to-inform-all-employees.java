class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] time = new int[n];
        for(int i = 0; i < n; i++) time[i] = -1;
        time[headID] = 0;
        int count = 1;
        while(count < n) {
            for(int i = 0; i < n; i++) {
                if(time[i] == -1 && time[manager[i]] != -1) {
                    time[i] = time[manager[i]] + informTime[manager[i]];
                    count++;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, time[i]);
        }
        return ans;
    }
}