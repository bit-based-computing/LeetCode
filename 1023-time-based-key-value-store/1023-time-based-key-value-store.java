class TimeMap {

    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.get(key) == null) {
            map.put(key, new TreeMap<Integer, String>());
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(map.get(key) == null) return "";
        TreeMap<Integer, String> sortedMap  = map.get(key);
        Integer timeKey = sortedMap.floorKey(timestamp);
        if(timeKey != null) return sortedMap.get(timeKey);
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */