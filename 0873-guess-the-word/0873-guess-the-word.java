class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // Build similarity map: count how many other words each word matches with (at least 1 position)
        for (int i = 0; i < wordlist.length - 1; i++) {
            for (int j = i + 1; j < wordlist.length; j++) {
                String word1 = wordlist[i];
                String word2 = wordlist[j];
                
                map.putIfAbsent(word1, 0);
                map.putIfAbsent(word2, 0);
                int s = compare(word1, word2);
                if (s > 0) {
                    map.put(word1, map.get(word1) + s);
                    map.put(word2, map.get(word2) + s);
                }
            }
        }

        // Sort wordlist based on similarity score (descending)
        Arrays.sort(wordlist, (w1, w2) -> map.get(w2) - map.get(w1));

        // Begin guessing
        for (int i = 0; i < wordlist.length; i++) {
            String guess = wordlist[i];
            if (guess.isEmpty()) continue;
            
            int matchCount = master.guess(guess);
            if (matchCount == 6) break;

            filterList(guess, i + 1, matchCount, wordlist);
        }
    }

    // Keep only the words that have the exact same match count with the guessed word
    private void filterList(String word, int start, int expectedMatches, String[] wordlist) {
        for (int i = start; i < wordlist.length; i++) {
            String curr = wordlist[i];
            if (curr.isEmpty()) continue;
            if (compare(word, curr) != expectedMatches) {
                wordlist[i] = "";
            }
        }
    }

    // Count how many characters match in the same position
    private int compare(String w1, String w2) {
        int count = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) == w2.charAt(i)) count++;
        }
        return count;
    }
}