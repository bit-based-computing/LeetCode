class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int len = asteroids.length;

        for(int i = len -1; i >= 0; i--) {
            int num = asteroids[i];
            if(num < 0) {
                s.add(num);
            } else {
                while(!s.isEmpty() && s.peek() < 0 && -s.peek() < num) {
                            s.pop();
                    }
                if(s.isEmpty() || s.peek() > 0) s.add(num);
                else if(s.peek() < 0 && -s.peek() == num) s.pop();
            }
        }
        int[] ans = new int[s.size()];
        int index = 0;
        while(!s.isEmpty()) {
            ans[index++] = s.pop();
        }
        return ans;
    }
}