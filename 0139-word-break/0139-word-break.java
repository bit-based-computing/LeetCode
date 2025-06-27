class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        for(String word: wordDict) {
            root.build(root, word);
        }
        Set<Integer> finds = new HashSet<>();
        finds.add(0);
        int index = 0;
        while(finds.size() > 0) {
            Set<Integer> wList = new HashSet<>();
            for(Integer startIndex: finds) {
                if(startIndex >= s.length()) return true;
                List<Integer> list = new ArrayList<>();
                list = root.search(root, startIndex, s);
                wList.addAll(list);
            }
            finds = wList;
        }
        return false;
    }
}

class Trie{
    Trie[] nodes = new Trie[26];
    boolean isWord = false;
    Trie() {
    }

    void build(Trie trie, String s) {
        int i = 0;
        int len = s.length();
        while(i < len) {
            int index = s.charAt(i) - 'a';
            if(trie.nodes[index] != null) {
                trie = trie.nodes[index];
            } else {
                trie.nodes[index] = new Trie();
                trie = trie.nodes[index];
            }
            i++;
        }
        trie.isWord = true;
    }


    List<Integer> search(Trie trie, int startIndex, String s) {
        List<Integer> finds = new ArrayList<>();
        int i = startIndex;
        int len = s.length();
        while(i < len) {
            int index = s.charAt(i) - 'a';
            if(trie.nodes[index] != null) {
                trie = trie.nodes[index];
                if(trie.isWord) {
                    finds.add(i + 1);
                }
            } else {
                break;
            }
            i++;
        }
        return finds;
    }
}