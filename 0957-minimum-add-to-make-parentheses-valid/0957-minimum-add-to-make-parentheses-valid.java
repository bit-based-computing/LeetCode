class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } 
            else { 
                if (open > 0) {
                    open--; // Match the current ')' with a previous '('
                } else {
                    close++; // No matching '(' for this ')'
                }
            }
        }

        // Total unmatched parentheses is sum of unmatched open and close
        return open + close;
    }
}