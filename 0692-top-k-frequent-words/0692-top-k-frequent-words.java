class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for(String word: words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        for(String word: freq.keySet()) {
            if(map.get(freq.get(word)) == null) map.put(freq.get(word), new ArrayList<String>());
            map.get(freq.get(word)).add(word);
        }

        List<Integer> sortedKeys = map.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<String> ans = new ArrayList<>();
        for(int i = 0; i < sortedKeys.size() && k > 0; i++) {
            List<String> ls = map.get(sortedKeys.get(i));
            ls.sort(Comparator.naturalOrder());
            for(String s: ls) {
                if(k <= 0) break;
                ans.add(s);
                k--;
            }
        }
        return ans;
    }
}