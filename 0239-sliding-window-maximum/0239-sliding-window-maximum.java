class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        LinkedList<Integer> max = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            while(!max.isEmpty() && nums[max.getLast()] < nums[i]) {
                max.removeLast();
            }
            max.addLast(i);
        }
        result[0] = nums[max.getFirst()];

        int l = 0;
        int r = k - 1;
        while( r < len - 1) {
            l++;
            r++;
            while(!max.isEmpty() && nums[max.getLast()] < nums[r]) {
                max.removeLast();
            }
            max.addLast(r);
            if(max.getFirst() < l) max.removeFirst();
            result[l] = nums[max.getFirst()];
        }
        return result;
    }
}