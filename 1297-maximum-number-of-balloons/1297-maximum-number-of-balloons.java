class Solution {
    public int maxNumberOfBalloons(String text) {
        int len = text.length();
        int min = len;
        char[] ctext = text.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            map.put(ctext[i], map.getOrDefault(ctext[i], 0) + 1);
        }
        String s = "loban";
        for(int i = 0; i < 5; i++) {
            int value = map.getOrDefault(s.charAt(i), 0);
            if((i == 0 || i == 1) && value > 0) {
                value = value/2;
            }
            min = Math.min(min, value);            
        }
        return min;
    }
}