class TimeMap {
        Node n;

        public TimeMap() {
            n = new Node();
        }

        public void set(String key, String value, int timestamp) {
            n = new Node(key, value, timestamp, n);
        }

        public String get(String key, int timestamp) {
            return search(key, timestamp, n);
        }

        private String search(String key, int timestamp, Node n) {
            if (n == null) return "";
            if (key.equals(n.key) && timestamp >= n.timestamp) return n.value;
            return search(key, timestamp, n.prev);
        }

        static class Node {
            String key;
            String value;
            int timestamp;
            Node prev;

            public Node() {
            }

            public Node(String key, String value, int timestamp, Node prev) {
                this.key = key;
                this.value = value;
                this.timestamp = timestamp;
                this.prev = prev;
            }
        }
}
