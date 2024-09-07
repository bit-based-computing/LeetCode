class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(List.of(1));
        if(numRows == 1) return ans;
        ans.add(List.of(1,1));
        if(numRows == 2) return ans;
        for(int i = 3; i <= numRows; i++) {
            List<Integer> nList = new ArrayList();
            nList.add(1);
            List<Integer> pList = ans.get(i-2);
            for(int j = 1; j < pList.size(); j++) {
                nList.add(pList.get(j) + pList.get(j-1));
            }
            nList.add(1);
            ans.add(nList);
        }
        return ans;
    }
}