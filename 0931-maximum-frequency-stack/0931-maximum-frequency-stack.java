class FreqStack {
    Map<Integer, Integer> map;
    Stack<Integer> stack;
    Stack<Integer> backup;
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));

    public FreqStack() {
        map = new HashMap<>();
        stack = new Stack<>();
        backup = new Stack<>();
        pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
    }
    
    public void push(int val) {
        stack.push(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
        pq.offer(map.get(val));
    }
    
    public int pop() {
        int x = pq.poll();
        while(!stack.isEmpty() && map.get(stack.peek()) < x) {
            backup.push(stack.pop());
        }
        int ans = stack.pop();
        while(!backup.isEmpty()) {
            stack.push(backup.pop());
        }
        map.put(ans, map.get(ans)- 1);
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */