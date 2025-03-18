class Solution {
    public String removeDuplicateLetters(String s) {
        int index = 0;
        int[] lastIndex = new int[26];
        boolean[] seen = new boolean[26];
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            index = cs[i] - 'a';
            lastIndex[index] = i;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            index = cs[i] - 'a';
            if (!seen[index]) {
                while (!stack.isEmpty() &&
                        stack.peek() > cs[i] && lastIndex[stack.peek() - 'a'] > i) {
                    seen[stack.peek() - 'a'] = false;
                    stack.pop();
                }
                stack.add(cs[i]);
                seen[index] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: stack) {
            sb.append(c);
        }
        return sb.toString();

    }
}