class Solution {
    public String removeDuplicates(String s) {
        int len = s.length();
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < len; i++) {
            if(stack.isEmpty()) {
                stack.add(cs[i]);
            } else {
                if(stack.peek() == cs[i]) {
                    stack.pop();
                } else {
                    stack.add(cs[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();
        }
        sb.reverse();
        return sb.toString();
    }
}