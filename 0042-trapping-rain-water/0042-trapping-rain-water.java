class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int minHeight = 0;
        int water = 0;
        int ans = 0;
        int len = height.length;
        int l = 0;
        int r = height.length - 1;
        while(l <= r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            minHeight = Math.min(leftMax, rightMax);
            if(height[l] <= height[r]) {
                water = minHeight - height[l];
                if(water > 0) ans += water;
                l++;
            } else {
                water = minHeight - height[r];
                if(water > 0) ans += water;
                r--;
            }
        }
        return ans;
    }
}