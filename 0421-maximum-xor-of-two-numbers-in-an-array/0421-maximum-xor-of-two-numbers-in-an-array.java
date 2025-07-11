class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int max = 0;
        for(int num: nums) {
            TrieNode currNode = root;
            TrieNode complement = root;
            int curMax = 0;
            for(int i = 31; i >= 0; i--) {
                int currBit = (num >> i) & 1;

                if(currNode.children[currBit] == null)
                    currNode.children[currBit] = new TrieNode();

                currNode = currNode.children[currBit];

                int toggleBit = currBit ^ 1;
                if(complement.children[toggleBit] != null) {
                    curMax = (curMax << 1) | 1;
                    complement = complement.children[toggleBit];
                } else {
                    curMax = (curMax << 1);
                    complement = complement.children[currBit];
                }

            }
            max = Math.max(max, curMax);
        } 
        return max;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[2];
}