class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        for (String word : wordDict) {
            root.build(root, word);
        }

        Set<Integer> finds = new HashSet<>();
        Set<Integer> visited = new HashSet<>(); // Track visited indices
        finds.add(0);

        while (!finds.isEmpty()) {
            Set<Integer> wList = new HashSet<>();
            for (Integer startIndex : finds) {
                if (startIndex == s.length()) return true;
                if (visited.contains(startIndex)) continue;
                visited.add(startIndex); // Mark as visited

                List<Integer> list = root.search(root, startIndex, s);
                wList.addAll(list);
            }
            finds = wList;
        }
        return false;
    }
}

class Trie {
    Trie[] nodes = new Trie[26];
    boolean isWord = false;

    Trie() {}

    void build(Trie trie, String s) {
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (trie.nodes[index] == null) {
                trie.nodes[index] = new Trie();
            }
            trie = trie.nodes[index];
        }
        trie.isWord = true;
    }

    List<Integer> search(Trie trie, int startIndex, String s) {
        List<Integer> finds = new ArrayList<>();
        int i = startIndex;
        while (i < s.length()) {
            int index = s.charAt(i) - 'a';
            if (trie.nodes[index] == null) break;
            trie = trie.nodes[index];
            if (trie.isWord) {
                finds.add(i + 1);
            }
            i++;
        }
        return finds;
    }
}
