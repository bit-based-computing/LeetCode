class MedianFinder {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int count = 0;
    public MedianFinder() {
        queue1 = new PriorityQueue<>((a, b) -> b - a);
        queue2 = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        count++;
        queue1.offer(num);
        if(!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        while (queue1.size() > queue2.size() + 1) {
            queue2.offer(queue1.poll());
        }
    }
    
    public double findMedian() {
        if(count % 2 == 1) {
            if(queue2.size() > queue1.size()) return queue2.peek();
            return queue1.peek();
        }
        return (double)(queue1.peek() + queue2.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */