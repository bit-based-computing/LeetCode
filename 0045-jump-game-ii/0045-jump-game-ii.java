class Solution {
    public int jump(int[] nums) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        for(int i = 1; i < nums.length; i++) {
            while(!queue.isEmpty()) {
                int[] peek = queue.peek();
                if((i - nums[peek[0]]) > peek[0]) {
                    queue.poll();
                } else {
                    break;
                }
            }
            queue.add(new int[] {i, queue.peek()[1] + 1});
            if(i == nums.length - 1) return queue.peek()[1] + 1;
        }
        return count;
    }
}