class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        List<Integer> lis = new ArrayList<>();
        for (int[] env : envelopes) {
            int h = env[1];
            int idx = lowerBound(lis, h);
            if (idx == lis.size()) {
                lis.add(h);
            } else {
                lis.set(idx, h);
            }
        }
        return lis.size();
    }

    // Custom binary search to find lower bound (first element >= target)
    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1, ans = list.size();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
