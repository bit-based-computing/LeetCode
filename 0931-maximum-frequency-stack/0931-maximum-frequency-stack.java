class FreqStack {
    Map<Integer, Integer> map;
    int i = 0;
    PriorityQueue<int[]> pq;

    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a,b)-> {
        if(a[2] == b[2]) return Integer.compare(b[0], a[0]);
        return Integer.compare(b[2], a[2]);
    });
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        pq.offer(new int[]{i++, val, map.get(val)});
    }
    
    public int pop() {
        int[] x = pq.poll();
        map.put(x[1], map.get(x[1]) - 1);
        return x[1];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */