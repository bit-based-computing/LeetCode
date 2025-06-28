class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TrieNode root = new TrieNode();

        for (String product : products) {
            TrieNode curNode = root;
            for (char ch : product.toCharArray()) {
                int index = ch - 'a';
                if (curNode.children[index] == null) {
                    curNode.children[index] = new TrieNode();
                }
                curNode = curNode.children[index];
                if (curNode.list.size() < 3) {
                    curNode.list.add(product);
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        TrieNode curNode = root;
        for (char ch : searchWord.toCharArray()) {
            curNode = find(ch, curNode);
            ans.add(curNode == null ? new ArrayList<>() : curNode.list);
        }

        return ans;
    }

    TrieNode find(char ch, TrieNode curNode) {
        if (curNode == null) return null;
        return curNode.children[ch - 'a'];
    }
}

class TrieNode {
    TrieNode[] children;
    List<String> list;

    TrieNode() {
        children = new TrieNode[26];
        list = new ArrayList<>();
    }
}
