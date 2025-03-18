class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int len = temp.length;
        int[] ans = new int[len];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && stack.peek()[0] < temp[i]) {
                ans[stack.peek()[1]] = i - stack.peek()[1];
                stack.pop();
            }
            stack.add(new int[]{temp[i], i});
        }
        return ans;
    }
}