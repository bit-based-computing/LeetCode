class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Double> set = new HashSet();
        Map<Double, Integer> count = new HashMap<>();
        set.add(distance(p1[0], p1[1], p2[0], p2[1], count));
        set.add(distance(p1[0], p1[1], p3[0], p3[1], count));
        set.add(distance(p1[0], p1[1], p4[0], p4[1], count));

        set.add(distance(p2[0], p2[1], p3[0], p3[1], count));
        set.add(distance(p2[0], p2[1], p4[0], p4[1], count));

        set.add(distance(p3[0], p3[1], p4[0], p4[1], count));

        if(set.size() == 2) {
            for(double d: set){
                if(d == 0) return false;
                if(count.get(d) != 4 && count.get(d) != 2) return false;
            }
            return true;
        }
        return false;
    }

    public Double distance(double x1, double y1, double x2, double y2, Map<Double, Integer> count ) {
        Double d =  Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        count.put(d, count.getOrDefault(d,0) + 1);
        return d;
    }
}