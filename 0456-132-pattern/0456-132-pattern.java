class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        int[] min = new int[len];
        min[0] = nums[0];
        for (int i = 1; i < len; i++) min[i] = Math.min(nums[i], min[i-1]);
        
        Stack<Integer> st = new Stack<>();

        for (int i = len - 1; i >= 1; i--) {
            int m = nums[i];
            if(m > min[i-1]) {
                while(!st.isEmpty() && st.peek() <= min[i-1]) st.pop();
                if(!st.isEmpty() && st.peek() < m) return true;
                st.push(m);
            }
        }

        return false;
    }
}