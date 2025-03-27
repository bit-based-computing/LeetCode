class Solution {
     public void generate(StringBuilder s, int open, int end, List<String> ans) {
        if(open == 0 && end == 0){
            ans.add(s.toString());
            return;
        }
        if(open > 0) {
            s.append('(');
            generate(s, open-1, end, ans);
            s.deleteCharAt(s.length() - 1);
        }
        if(open < end) {
            s.append(')');
            generate(s, open, end - 1, ans);
            s.deleteCharAt(s.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(new StringBuilder(), n, n, ans);
        return ans;
    }
}