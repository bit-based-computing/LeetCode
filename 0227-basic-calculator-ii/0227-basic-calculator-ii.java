class Solution {
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        int num = 0;
        char[] chars = s.toCharArray();
        char lastSign = '+';
        
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if(!Character.isDigit(c) && c != ' ' || i == chars.length-1) {
                if(lastSign == '+') {
                    operands.push(num);
                } else if(lastSign == '-') {
                    operands.push(-num);
                } else {
                    int top = operands.pop();
                    if(lastSign == '*') operands.push(top*num);
                    else operands.push(top/num);
                }
                num = 0;
                lastSign = c;
            }
        }
        int sum = 0;
        while(!operands.isEmpty()) {
            sum += operands.pop();
        }
        return sum;
    }
}