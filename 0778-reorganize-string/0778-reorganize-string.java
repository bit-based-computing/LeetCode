class Solution {
    public String reorganizeString(String s) {
        char[] array = s.toCharArray();
        int[] freq = new int[26];
        int len = s.length();
        int distinict = 0;
        for(int i = 0; i < len; i++) {
            freq[array[i]-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int k = 0;
        int hf = 0;
        char hfc = 'a';
        int index = -1;
        while(k < len){
             hf = 0;
             hfc = 'a';
            for(int i = 0; i < 26 ; i++){
                if(freq[i] > hf) {
                    hf = freq[i];
                    hfc = (char) (i + 'a');
                    index = i;
                }
            }
            freq[hfc - 'a']--;
            sb.append(hfc);
            boolean found = false;
            for(int i = 0; i < 26; i++) {
                if(i != index && freq[i] > 0) {
                    char x = (char) (i + 'a');
                    sb.append(x);
                    freq[i]--;
                    found = true;
                    break;
                }
            }
            k += 2;
            if(!found) break;
        }
        String ans = sb.toString();
        if(ans.length() == len) return ans;
        return "";
    }
}