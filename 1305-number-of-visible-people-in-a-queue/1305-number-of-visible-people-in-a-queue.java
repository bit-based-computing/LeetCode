class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] ans = new int[len];
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = len - 1; i >= 0; i--) {
            count = 0;
            while(!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                count++;
                stack.pop();
            }

            if(!stack.isEmpty()) {
                count++;
            }
            ans[i] = count;
            stack.add(i);
        }
        return ans;
    }
}