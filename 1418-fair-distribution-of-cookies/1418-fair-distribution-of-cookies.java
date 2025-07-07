class Solution {
    int ans = Integer.MAX_VALUE;
    Map<String, Integer> memo = new HashMap<>();

    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        backtrack(cookies, 0, children, k);
        return ans;
    }

    private void backtrack(int[] cookies, int index, int[] children, int k) {
        if (index == cookies.length) {
            int unfairness = 0;
            for (int c : children) unfairness = Math.max(unfairness, c);
            ans = Math.min(ans, unfairness);
            return;
        }

        String key = index + "#" + Arrays.toString(children);
        if (memo.containsKey(key)) return;
        memo.put(key, ans);

        for (int i = 0; i < k; i++) {
            // Prune: don't give to same empty child again
            if (i > 0 && children[i] == children[i - 1]) continue;

            children[i] += cookies[index];
            if (children[i] < ans) {
                backtrack(cookies, index + 1, children, k);
            }
            children[i] -= cookies[index];

            // Optimization: if this child has no cookies, break to avoid duplicates
            if (children[i] == 0) break;
        }
    }
}
