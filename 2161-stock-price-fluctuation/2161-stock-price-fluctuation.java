class StockPrice {
    int current;
    int currentValue;

    Map<Integer, Integer> count;
    Map<Integer, Integer> map;
    TreeSet<Integer> values;

    public StockPrice() {
        current = 0;
        currentValue = 0;
        count = new HashMap<>();
        map = new HashMap<>();
        values = new TreeSet<>();
    }
    
    public void update(int timestamp, int price) {
        if(timestamp >= current){
            current = timestamp;
            currentValue = price;
        } 
        if(map.get(timestamp) != null) {
            int x = map.get(timestamp);
            if(x != price && count.get(x) < 2) {
                values.remove((Integer) x);
            }
            count.put(x, count.get(x)-1);
        }
        map.put(timestamp, price);
        count.put(price, count.getOrDefault(price, 0) + 1);
        values.add(price);
    }
    
    public int current() {
       return currentValue;
    }
    
    public int maximum() {
        return values.last();
    }
    
    public int minimum() {
        return values.first();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */