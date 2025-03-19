class StockSpanner {

    Stack<int []> stack;
    int i;
    int ans;
    public StockSpanner() {
        stack = new Stack<>();
        stack.add(new int[]{100001, 0});
        i = 0;
    }
    
    public int next(int price) {
        i++;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop(); 
        }
        ans = i - stack.peek()[1];
        stack.add(new int[] {price, i});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */