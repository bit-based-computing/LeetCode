class Trie {

    class Node{
        Map<Character, Node> map = new HashMap<>();
        boolean isEnd = false;
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(curr.map.get(c) == null) {
                curr.map.put(c, new Node());
            }
            curr = curr.map.get(c);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(curr.map.get(c) == null) {
                return false;
             }
            curr = curr.map.get(c);
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if(curr.map.get(c) == null) {
                return false;
             }
            curr = curr.map.get(c);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */