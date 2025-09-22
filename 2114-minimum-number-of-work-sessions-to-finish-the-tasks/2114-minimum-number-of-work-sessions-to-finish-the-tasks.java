class Solution {
    private int[][] memo;

    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        memo = new int[1 << n][sessionTime + 1];
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(tasks, sessionTime, 0, 0, 0);
    }

    private int dfs(int[] tasks, int st, int currTask, int bitmask, int count) {
        if (count == tasks.length) {
            return currTask == 0 ? 0 : 1;
        }

        if (memo[bitmask][currTask] != -1) {
            return memo[bitmask][currTask];
        }

        int n = tasks.length;
        int minCount = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if ((bitmask & (1 << i)) == 0 && currTask + tasks[i] <= st) {
                found = true;
                int c = dfs(tasks, st, currTask + tasks[i], bitmask | (1 << i), count + 1);
                minCount = Math.min(minCount, c);
            }
        }

        if (!found) {
            minCount = 1 + dfs(tasks, st, 0, bitmask, count);
        }

        return memo[bitmask][currTask] = minCount;
    }
}
