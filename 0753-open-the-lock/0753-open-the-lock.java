import java.util.*;

public class Solution {

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add("0000");
        endSet.add(target);

        Set<String> visited = new HashSet<>();
        visited.add("0000");
        visited.add(target);

        int depth = 0;

        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }

            Set<String> next = new HashSet<>();
            for (String current : startSet) {
                if (deadSet.contains(current)) continue;

                for (String neighbor : getNextStates(current)) {
                    if (endSet.contains(neighbor)) {
                        return depth + 1; // ✅ found connection
                    }
                    if (!visited.contains(neighbor) && !deadSet.contains(neighbor)) {
                        visited.add(neighbor);
                        next.add(neighbor);
                    }
                }
            }
            startSet = next;
            depth++;
        }

        return -1;
    }

    private List<String> getNextStates(String current) {
        List<String> states = new ArrayList<>();
        char[] chars = current.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = chars[i];

            // Forward
            chars[i] = (original == '9') ? '0' : (char)(original + 1);
            states.add(new String(chars));

            // Backward
            chars[i] = (original == '0') ? '9' : (char)(original - 1);
            states.add(new String(chars));

            chars[i] = original;
        }
        return states;
    }
}
