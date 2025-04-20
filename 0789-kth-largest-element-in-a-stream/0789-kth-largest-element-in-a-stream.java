class KthLargest {
    Queue<Integer> q;
    int x = 0;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        x = k;
        for(int i = 0;  i < nums.length; i++) {
            q.add(nums[i]);
            if(q.size()>k) q.poll();
        }
    }
    
    public int add(int val) {
        q.add(val);
        if(q.size() > x) q.poll();
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */