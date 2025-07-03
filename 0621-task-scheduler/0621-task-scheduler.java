class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int[] lastET = new int[26];
        int count = 0;
        for(char c: tasks) {
            int index  = c - 'A';
            freq[index]++;
            count++; 
        }
        int curTime = 1;
        while(count > 0) {
            int maxFreq = 0;
            int index = -1;
            // System.out.println(curTime + " " + count);
            for(int i = 0; i < 26; i++) {
                if(freq[i] > 0 && (lastET[i] == 0 || (lastET[i] + n < curTime)) && freq[i] > maxFreq) {
                    maxFreq = freq[i];
                    index = i;
                }
            }
            if(index != -1) {
                freq[index]--;
                count--;
                lastET[index] = curTime;
                curTime++;
            } else {
                curTime++;
            }
        }
        return curTime - 1;
    }
}