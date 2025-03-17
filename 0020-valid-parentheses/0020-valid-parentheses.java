class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.add(cs[i]);
            } else {
                if(cs[i] == '(' || cs[i] == '{' || cs[i] == '{') {
                    stack.add(cs[i]);
                } else if(cs[i] == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if(cs[i] == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if(cs[i] == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.add(cs[i]);
                }
            }
        }
        return stack.isEmpty();
    }
}