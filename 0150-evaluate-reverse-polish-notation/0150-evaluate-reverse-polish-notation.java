class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<>();
        int ans = 0;
        for (String s : tokens) {
            if (!isOperator(s)) {
                number.add(Integer.parseInt(s));
            } else {
                System.out.println(number.size());
                int x = number.pop();
                int y = number.pop();
                if (s.equals("+")) {
                    number.add(y + x);
                } else if (s.equals("-")) {
                    number.add(y - x);
                } else if (s.equals("/")) {
                    number.add(y / x);
                } else if (s.equals("*")) {
                    number.add(x * y);
                }
            }
        }
        return number.pop();
    }

    boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}