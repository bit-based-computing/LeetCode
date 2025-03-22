class Solution {
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> min = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        int ans = 0;
        int len = 0;
        int num = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            num = nums[r];

            while (!min.isEmpty() && min.getLast() > num) {
                min.removeLast();
            }
            min.addLast(num);

            while (!max.isEmpty() && max.getLast() < num) {
                max.removeLast();
            }
            max.addLast(num);

            while (Math.abs(min.getFirst() - num) > limit ||
                    Math.abs(max.getFirst() - num) > limit) {
                if (nums[l] == min.getFirst())
                    min.removeFirst();
                if (nums[l] == max.getFirst())
                    max.removeFirst();
                l++;
            }
            len = r - l + 1;
            if(len > ans) ans = len;
            r++;
        }
        return ans;
    }
}