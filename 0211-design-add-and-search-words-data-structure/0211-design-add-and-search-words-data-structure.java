class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie temp = root;
        int len = word.length();
        int i = 0;
        while(i < len) {
            int index  = word.charAt(i) - 'a';
            if(temp.nodes[index] == null) {
                temp.nodes[index] = new Trie();
            }
            temp = temp.nodes[index];
            i++;
        }
        temp.isWord = true;
    }
    
    public boolean search(String word) {
        return find(0, root, word);
    }
    public boolean find(int i, Trie temp, String word) {
        if(i == word.length()){
            // if(word.charAt(i-1) == '.') return true;
            return temp.isWord;
        } 
        boolean ans = false;
        if(word.charAt(i) == '.') {
            for(Trie node: temp.nodes) {
                if(node != null) {
                    ans  = ans || find(i+1, node, word);
                }
                if(ans) return ans;
            }
        } else {
            int index  = word.charAt(i) - 'a';
            if(temp.nodes[index] == null) return false;
            ans = find(i+1, temp.nodes[index], word);
        }
        return ans;
    }
}

class Trie{
    Trie[] nodes;
    boolean isWord;
    Trie() {
        nodes = new Trie[26];
        isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */