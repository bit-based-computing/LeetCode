
class CMap {
    int value;
    public CMap() {
    }
}
class MyHashMap {
    CMap[] maps;
    public MyHashMap() {
         maps = new CMap[1000001]; 
    }
    
    public void put(int key, int value) {
        if(maps[key] == null) {
            maps[key] = new CMap();
        }
        maps[key].value = value;
    }
    
    public int get(int key) {
        if(maps[key] == null) return -1;
        return maps[key].value;
    }
    
    public void remove(int key) {
        maps[key] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */