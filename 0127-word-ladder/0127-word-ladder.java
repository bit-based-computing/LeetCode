class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue  = new LinkedList<>();
        Map<String,Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        queue.offer(beginWord);
        int time = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String begin = queue.poll();
                if(begin.equals(endWord)) return time;
                for(String word: wordList) {
                    if(map.get(word) == null && differenceChar(begin, word) == 1) {
                        queue.offer(word);
                        map.put(word, 1);
                    }
                }
            }
            time++;
        }
        return 0;
    }

    int differenceChar(String word1, String word2) {
        int len = word1.length();
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(word1.charAt(i) != word2.charAt(i)) count++;
        }
        return count;
    }
}