class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]); // weight then index
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2])); // freeTime

        for (int i = 0; i < servers.length; i++) {
            freeServers.offer(new int[]{i, servers[i]}); // {index, weight}
        }

        int[] result = new int[tasks.length];
        int time = 0;

        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);

            // Move available servers back
            while (!busyServers.isEmpty() && busyServers.peek()[2] <= time) {
                int[] s = busyServers.poll();
                freeServers.offer(new int[]{s[0], s[1]});
            }

            // If no server is free, advance time
            if (freeServers.isEmpty()) {
                time = busyServers.peek()[2];
                while (!busyServers.isEmpty() && busyServers.peek()[2] <= time) {
                    int[] s = busyServers.poll();
                    freeServers.offer(new int[]{s[0], s[1]});
                }
            }

            int[] server = freeServers.poll();
            result[i] = server[0];
            busyServers.offer(new int[]{server[0], server[1], time + tasks[i]}); // {index, weight, freeTime}
        }

        return result;
    }
}
