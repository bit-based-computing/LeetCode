class Solution {
    int min;
    public int distributeCookies(int[] cookies, int k) {
        int[] child = new int[k];
        min = Integer.MAX_VALUE;
        dfs(0, cookies, child);
        return min;
    }

    void dfs(int index, int[] cookies, int[] child) {
        
        if(index >= cookies.length) {
            int max = 0;
            for(int x: child) {
                max = Math.max(max, x);
            }
            min = Math.min(min, max);
            return;
        }
        for(int i = 0; i < child.length; i++) {
            child[i] += cookies[index];
            dfs(index + 1, cookies, child);
            child[i] -= cookies[index];
        }
    }
}