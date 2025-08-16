class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) return steps;

                for (int j = 0; j < 4; j++) {
                    char c = curr.charAt(j);
                    int num = c - '0'; // char → digit
                    // two neighbors: turn wheel up and down
                    int[] nextNums = { (num + 1) % 10, (num + 9) % 10 };

                    for (int next : nextNums) {
                        String nextState = curr.substring(0, j) + next + curr.substring(j + 1);
                        if (!dead.contains(nextState) && visited.add(nextState)) {
                            queue.add(nextState);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
