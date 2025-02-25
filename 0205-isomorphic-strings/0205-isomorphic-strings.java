class Solution {
    public boolean isIsomorphic(String s, String t) {
         if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if sToT mapping is violated
            if (sToT.containsKey(charS) && sToT.get(charS) != charT) {
                return false;
            }

            // Check if tToS mapping is violated
            if (tToS.containsKey(charT) && tToS.get(charT) != charS) {
                return false;
            }

            sToT.put(charS, charT);
            tToS.put(charT, charS);
        }

        return true;
    }

}