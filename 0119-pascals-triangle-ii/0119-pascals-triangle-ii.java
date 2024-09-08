class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) return List.of(1);
        if(rowIndex == 1) return List.of(1,1);
        List<Integer> prev = List.of(1,1);
        for(int i = 2; i <= rowIndex; i++) {
            List<Integer> nl = new ArrayList<>();
            nl.add(1);
            for(int j = 1; j < prev.size(); j++) {
                nl.add(prev.get(j) + prev.get(j-1));
            }
            nl.add(1);
            prev = nl;
        }
        return prev;
    }
}