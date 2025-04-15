class MyPair {
    int x;
    int y;
    public MyPair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class MyCalendar {
    List<MyPair> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        return isIntersect(startTime, endTime-1);
    }
    public boolean isIntersect(int x, int y) {
        for(MyPair pair: list) {
            if((pair.x <= x && x <= pair.y) || (pair.x <= y && y <= pair.y)) {
                return false;
            } else if((x <= pair.x && pair.x <= y) && (x <= pair.y && pair.y <= y)) {
                return false;
            }
        }
        list.add(new MyPair(x,y));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */