class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sorted = new int[n][3];

        for (int i = 0; i < n; i++) {
            sorted[i][0] = tasks[i][0]; // enqueue time
            sorted[i][1] = tasks[i][1]; // processing time
            sorted[i][2] = i;           // index
        }

        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int time = 0, idx = 0, i = 0;
        int[] result = new int[n];

        while (i < n) {
            while (idx < n && sorted[idx][0] <= time) {
                pq.offer(new int[]{sorted[idx][2], sorted[idx][1]});
                idx++;
            }

            if (!pq.isEmpty()) {
                int[] task = pq.poll();
                result[i++] = task[0];
                time += task[1];
            } else {
                time = sorted[idx][0];
            }
        }

        return result;
    }
}
