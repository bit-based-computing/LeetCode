class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
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
                sb.append(strs[0].charAt(index));
                index++;  
            } 
            else break;
        }
        return sb.toString();
    }
}