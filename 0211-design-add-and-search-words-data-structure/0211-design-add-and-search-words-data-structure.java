class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.nodes[index] == null) {
                curr.nodes[index] = new Trie();
            }
            curr = curr.nodes[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return find(0, root, word);
    }

    private boolean find(int i, Trie node, String word) {
        if (i == word.length()) return node.isWord;

        char ch = word.charAt(i);
        if (ch == '.') {
            for (Trie child : node.nodes) {
                if (child != null && find(i + 1, child, word)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = ch - 'a';
            if (node.nodes[index] == null) return false;
            return find(i + 1, node.nodes[index], word);
        }
    }
}

class Trie {
    Trie[] nodes;
    boolean isWord;

    Trie() {
        nodes = new Trie[26];
        isWord = false;
    }
}
