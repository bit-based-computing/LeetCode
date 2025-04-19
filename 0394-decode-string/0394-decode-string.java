class Solution {
    public boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isOpen(char c) {
        return c == '[';
    }

    public boolean isClose(char c) {
        return c == ']';
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            int j = i + 1;
            if (isLetter(c)) {
                while (j < len && isLetter(s.charAt(j))) {
                    sb.append(s.charAt(j));
                    j++;
                }
                i = j - 1;
                stack.add(sb.toString());
            } else if (isDigit(c)) {
                while (j < len && isDigit(s.charAt(j))) {
                    sb.append(s.charAt(j));
                    j++;
                }
                i = j - 1;
                stack.add(sb.toString());
            } else if (isOpen(c)) {
                stack.add(sb.toString());
            } else if (isClose(c)) {
                String ns = "";
                int count = 0;
                while (!stack.isEmpty()) {
                    String spop = stack.pop();
                    if (spop.equals("[")) {
                        if(count > 0) stack.add(spop);
                        if (count > 0)
                            break;
                        count++;
                        continue;
                    }
                    if (isDigit(spop.charAt(0))) {
                        int x = Integer.parseInt(spop);
                        String cs = ns;
                        for (int k = 1; k < x; k++) {
                            ns = ns + cs;
                        }
                    } else {
                        ns = spop + ns;
                    }
                }
                stack.add(ns);
            }
        }

        String ns = "";
        while (!stack.isEmpty()) {
            String spop = stack.pop();
            ns = spop + ns;
        }
        return ns;
    }
}