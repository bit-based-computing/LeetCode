class Pair {
    int key;
    int value;
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {

    int bucketSize = 10000;
    List<Pair> [] bucket;

    public MyHashMap() {
        bucket = new ArrayList[bucketSize];
        for(int i = 0; i < bucketSize; i++) {
            bucket[i] = new ArrayList<>();
        }
    }
    
    public void put(int key, int value) {
        int idx = key % bucketSize;
        for(Pair pair: bucket[idx]) {
            if(pair.key == key) {
                pair.value = value;
                return;
            }
        }

        bucket[idx].add(new Pair(key, value));
    }
    
    public int get(int key) {
        int idx = key % bucketSize;
        for(Pair pair: bucket[idx]) {
            if(pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = key % bucketSize;
        Pair removePair = null;
        for(Pair pair: bucket[idx]) {
            if(pair.key == key) {
                removePair = pair;
                break;
            }
        }
        if(removePair != null) {
            bucket[idx].remove(removePair);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */