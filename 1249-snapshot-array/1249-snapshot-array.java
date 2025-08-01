class SnapshotArray {
    
    Map<Integer, TreeMap<Integer, Integer>> snapMap;
    int snap_id = 0;
    public SnapshotArray(int length) {
        snapMap = new HashMap<>();
        snap_id = 0;
    }
    
    public void set(int index, int val) {
       snapMap.computeIfAbsent(index, k-> new TreeMap<>()).put(snap_id, val);
    }
    
    public int snap() {
        snap_id++;
        return snap_id - 1;
    }
    
    public int get(int index, int snap_id) {
        if(snapMap.get(index) == null) return 0;
        Map.Entry<Integer, Integer> entry = snapMap.get(index).floorEntry(snap_id);
        return entry == null ? 0 : entry.getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */