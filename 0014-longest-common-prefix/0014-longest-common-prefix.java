class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        int slen = strs.length;
        while(true) {
            int count = 0;
            for(int i = 0; i < slen; i++) {
                if(index < strs[i].length() && strs[0].charAt(index) == strs[i].charAt(index)) {
                    count++;
                } else {
                    break;
                }
            }
            if(count == slen){
                index++;  
            } 
            else break;
        }
        return strs[0].substring(0, index);
    }
}