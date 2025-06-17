public class Node {
    boolean isWord;
    Node[] charaters = new Node[26];
    public Node() {

    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        int len = word.length()-1;
        Node temp = root;
        for(int i = 0; i <= len; i++) {
            int index = word.charAt(i) - 'a';
            // System.out.println(word.charAt(i) + " " + index);
            if(temp.charaters[index] != null) {
                temp = temp.charaters[index];
                if(i == len) temp.isWord = true;
            } else {
                Node node = new Node();
                temp.charaters[index] = node;
                temp = node;
                if(i == len) {
                    node.isWord = true;
                }
            }
        }
        
    }
    
    public boolean search(String word) {
        int len = word.length()-1;
        Node temp = root;
        for(int i = 0; i <= len; i++) {
            int index = word.charAt(i) - 'a';
            // System.out.println(word.charAt(i) + " s " + index);
            if(temp.charaters[index] != null) {
                temp = temp.charaters[index];
            } else {
                return false;
            }
            if(i == len && temp.isWord == true) {
                return true;
            }
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length()-1;
        Node temp = root;
        for(int i = 0; i <= len; i++) {
            int index = prefix.charAt(i) - 'a';
            if(temp.charaters[index] != null) {
                temp = temp.charaters[index];
            } else {
                return false;
            }
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