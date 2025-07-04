class Solution {
    public int rob(int[] nums) {
        int[] money = robHouse(0, nums);
        return Math.max(money[0], money[1]);
    }

    int[] robHouse(int index, int[] nums) {
        if(index >= nums.length) return new int[]{0,0};
        int[] nextRob = robHouse(index + 1, nums);
        int rob = nums[index] + nextRob[1];
        int nrob = Math.max(nextRob[0], nextRob[1]);
        // System.out.println(index + " " + rob + " " + nrob);
        return new int[]{rob, nrob};
    }
}