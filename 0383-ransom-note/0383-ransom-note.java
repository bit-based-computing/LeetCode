class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomFreq = new int[26];
        int[] magaFreq = new int[26];
        char[] rn = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        for(int i = 0; i < magazine.length(); i++) {
            magaFreq[maga[i] - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            ransomFreq[rn[i] - 'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++){
            if(ransomFreq[rn[i] - 'a'] > magaFreq[rn[i] - 'a']) {
                return false;
            }
        }
        return true;
    }
}