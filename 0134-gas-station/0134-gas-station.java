class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int max = 0;
        int min = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++) {
            max += gas[i];
            max -= cost[i];
            if(max < min) {
                min = max;
                index = i + 1;
            }
        }
        if(max < 0 ) return -1;
        return index % gas.length;
        
    }
}