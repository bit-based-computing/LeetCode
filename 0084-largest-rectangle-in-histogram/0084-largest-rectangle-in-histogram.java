class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int area = 0;
        int index = 0;
        while(index < heights.length) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
                stack.add(index++);
            } else {
                int top = stack.pop();
                area = heights[top] * (stack.isEmpty()? index: index - stack.peek() - 1);
                if(area > maxArea) maxArea = area;
            }
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            area = heights[top] * (stack.isEmpty()? index: index - stack.peek() - 1);
            if(area > maxArea) maxArea = area;
        }
        return maxArea;
    }
}