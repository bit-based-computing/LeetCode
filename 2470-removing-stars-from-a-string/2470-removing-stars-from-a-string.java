class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        char c = 'a';
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c != '*') {
                stack.add(c);
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}