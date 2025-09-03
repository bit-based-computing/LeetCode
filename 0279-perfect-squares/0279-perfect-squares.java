class Solution {
    int min = 10001;
    public int numSquares(int n) {
        List<Integer> ps = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            int sqr = i * i;
            if(sqr > n) break;
            ps.add(sqr);
        }
        Collections.sort(ps, Collections.reverseOrder());
        // System.out.println(ps.size());
        dfs(0, 0, 0, n, ps);
        return min;
    }

    void dfs(int index, int curSum, int count, int n, List<Integer> ps) {
    if(curSum == n) {
        min = Math.min(min, count);
        return;
    }
    if(index >= ps.size() || curSum > n || count >= min) return;

    dfs(index, curSum + ps.get(index), count + 1, n, ps);

    dfs(index + 1, curSum, count, n, ps);
}

}