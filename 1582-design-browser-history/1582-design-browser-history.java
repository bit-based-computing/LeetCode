class BrowserHistory {
    
    Stack<String> forward;
    Stack<String> back; 

    public BrowserHistory(String homepage) {
        
        forward = new Stack<>();
        back = new Stack<>();
        forward.push(homepage);
    }
    
    public void visit(String url) {
        forward.push(url);
        back.clear();
    }
    
    public String back(int steps) {
        while(forward.size() > 1 && steps > 0) {
            back.push(forward.pop());
            steps--;
        }
        if(!forward.isEmpty()) return forward.peek();
        return null;
    }
    
    public String forward(int steps) {
        while(back.size() > 0 && steps > 0) {
            forward.push(back.pop());
            steps--;
        }
        if(!forward.isEmpty()) return forward.peek();
        return null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */