class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);

        // Binary search from right (latest timestamp)
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (list.get(m).timestamp <= timestamp) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return r >= 0 ? list.get(r).value : "";
    }

    static class Pair {
        int timestamp;
        String value;
        Pair(int t, String v) {
            this.timestamp = t;
            this.value = v;
        }
    }
}
