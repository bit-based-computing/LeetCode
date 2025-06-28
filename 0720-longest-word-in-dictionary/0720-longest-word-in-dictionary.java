class Solution {
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        TrieNode currNode = root;
        for(String word: words) {
            currNode = root;
            for(char ch: word.toCharArray()) {
                int index = ch - 'a';
                if(currNode.childrens[index] == null)
                    currNode.childrens[index] = new TrieNode();
                currNode = currNode.childrens[index];
            }
            currNode.isWord = true;
            currNode.word = word;
        }
        Queue<TrieNode> queue = new LinkedList<>();
        for(TrieNode node: root.childrens) {
            if(node != null && node.isWord) {
                queue.add(node);
            }
        }
        String ans = "";
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                currNode = queue.poll();
                if(i == 0) ans = currNode.word;
                for(TrieNode children: currNode.childrens) {
                    if(children != null && children.isWord) {
                        queue.add(children);
                    }
                }
            }
        }

        return ans;
    }
}

class TrieNode{
    TrieNode[] childrens;
    boolean isWord;
    String word;

    TrieNode() {
        childrens = new TrieNode[26];
        isWord = false;
    }
}