class Pair{
    char c;
    int index;
    Pair(char c, int index) {
        this.c = c;
        this.index = index;
    }
}
class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Pair> stack = new Stack<>();
        char c = 'x';
        Pair peek;
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(stack.empty()) {
                stack.add(new Pair(c,i));
            } else {
                peek = stack.peek();
                if(peek.c == '(' && c == ')') {
                    stack.pop();
                    if(stack.isEmpty()) {
                        if(i + 1 > ans) ans = i + 1;
                    } else {
                        peek = stack.peek();
                        if(i - peek.index > ans) ans = i - peek.index;
                    }
                   
                } else {
                    stack.add(new Pair(c,i));
                }
            }
        }
        return ans;
    }
}