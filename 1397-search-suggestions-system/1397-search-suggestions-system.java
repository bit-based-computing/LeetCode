class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TrieNode root = new TrieNode();
        TrieNode curNode = root;
        for(String product: products) {
            int i = 0;
            int len = product.length();
            curNode = root;
            while(i < len) {
                char ch = product.charAt(i);
                int index  = ch - 'a';
                if(curNode.childrens[index] == null) {
                    curNode.childrens[index] = new TrieNode();
                }
                curNode = curNode.childrens[index];
                if(curNode.list.size() < 3) {
                    curNode.list.add(product);
                }
                i++;
            }
        }

        List<List<String>> ans = new ArrayList<>();
        curNode = root;
        int start = 0;
        for(int i = 0; i < searchWord.length(); i++) {
            curNode = find(start, i, curNode, searchWord);
            start = i + 1;
            if(curNode == null) {
                start = 0;
                curNode = root;
            }
            ans.add(curNode.list);
        }
        return ans;
    }

    TrieNode find(int start, int end, TrieNode curNode, String searchWord) {
            List<String> ans = new ArrayList<>();
            while(start <= end) {
                char ch = searchWord.charAt(start);
                int index = ch - 'a';
                if(curNode.childrens[index] == null) return null;
                curNode = curNode.childrens[index];
                start++;
            }
            return curNode;
    }
}

class TrieNode{
    TrieNode[] childrens;
    List<String> list;
    
    TrieNode() {
        childrens = new TrieNode[26];
        list = new ArrayList<>();
    }
}