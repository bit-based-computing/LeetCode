class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int currentPosition = 0;
        int maxPosition = 0;
        int currentEnd = 0;
        while (currentEnd < nums.length - 1) {
            maxPosition = Math.max(maxPosition, nums[currentPosition] + currentPosition);
            if (currentPosition == currentEnd) {
                count++;
                currentEnd = maxPosition;
            }
            currentPosition++;
        }
        return count;
    }
}