class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TrieNode root = new TrieNode();
        for(String product: products) {
            int i = 0;
            int len = product.length();
            TrieNode curNode = root;
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
        for(int i = 0; i < searchWord.length(); i++) {
            ans.add(find(0, i, root, searchWord));
        }
        return ans;
    }

    List<String> find(int start, int end, TrieNode curNode, String searchWord) {
            List<String> ans = new ArrayList<>();
            while(start <= end) {
                char ch = searchWord.charAt(start);
                int index = ch - 'a';
                if(curNode.childrens[index] == null) return ans;
                curNode = curNode.childrens[index];
                start++;
            }
            return curNode.list;
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