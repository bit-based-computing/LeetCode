class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
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
                curNode.list.offer(product);
                if(curNode.list.size() > 3) {
                    curNode.list.poll();
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
            while(!curNode.list.isEmpty()) {
                ans.add(curNode.list.poll());
            }
            Collections.sort(ans);
            return ans;
    }
}

class TrieNode{
    TrieNode[] childrens;
    PriorityQueue<String> list;
    
    TrieNode() {
        childrens = new TrieNode[26];
        list = new PriorityQueue<>(Comparator.reverseOrder());
    }
}