class Solution {
    private static final long MOD = 2_000_000_000;

    public String longestDupSubstring(String s) {
        int l = 1;
        int r = s.length();
        String result = "";
        while (l < r) {
            int mid = l + (r - l) / 2;
            String dup = findDuplicate(s, mid);
            if (dup != null) {
                result = dup;
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return result;
    }

    String findDuplicate(String s, int len) {

        long base = 256;
        long hash = 0;
        long pow = 1;
        Map<Long, List<Integer>> seen = new HashMap<>();

        for(int i = 0; i < len; i++) {
            hash = (hash * base + s.charAt(i)) % MOD;
            pow = (pow * base) % MOD;
        }
        seen.putIfAbsent(hash, new ArrayList<>());
        seen.get(hash).add(0);

        for(int i = len ; i < s.length(); i++) {
            hash = ( (hash * base) % MOD + s.charAt(i) ) % MOD;
            hash = (hash - (s.charAt(i-len) * pow) % MOD + MOD) % MOD;
            if(seen.containsKey(hash)) {
                for(int start: seen.get(hash)) {
                    if(s.substring(start, start+len).equals(s.substring(i- len + 1, i+1))){
                        return s.substring(start, start+len);
                    }
                }
            }
            seen.putIfAbsent(hash, new ArrayList<>());
            seen.get(hash).add(i - len + 1);
        }
        return null;
    }
}