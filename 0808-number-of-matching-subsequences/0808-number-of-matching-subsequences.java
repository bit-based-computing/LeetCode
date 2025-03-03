class Solution {

    int getLowerBound(int x, List<Integer> list) {
            int l = 0;
            int r = list.size() - 1;
            while(l < r) {
                int mid = l + (r - l) / 2;
                if(x >= list.get(mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if(l < r && list.get(l) <= x) l++;
            return list.get(l);
    }
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] sc = s.toCharArray();
        int ans = 0;
        int start = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.get(sc[i]) == null)map.put(sc[i], new ArrayList<Integer>());
            map.get(sc[i]).add(i);
        }
        for(int i = 0; i < words.length; i++) {
            start = -1;
            count = 0;
            for(int j = 0; j < words[i].length(); j++) {
                char x = words[i].charAt(j);
                if(map.get(x) != null){
                    int nextIndex = getLowerBound(start, map.get(x));
                    if(nextIndex > start) {
                        start = nextIndex;
                        count++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if(count == words[i].length()) ans++;
        }
        return ans;
    }
}