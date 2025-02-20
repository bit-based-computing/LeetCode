class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magaFreq = new int[26];
        char[] rn = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        for(int i = 0; i < magazine.length(); i++) {
            magaFreq[maga[i] - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            if(magaFreq[rn[i] - 'a'] > 0) {
                magaFreq[rn[i] - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}