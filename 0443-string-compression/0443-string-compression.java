class Solution {
    int index = 0;

    public int compress(char[] chars) {
        int len = chars.length;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count > 1)
                    setCount(chars, i - 1, count);
                else
                    chars[index++] = chars[i - 1];
                count = 1;
            }
        }
        if (count > 1)
            setCount(chars, len - 1, count);
        else
          chars[index++] = chars[len-1];
    
        return index;
    }

    private void setCount(char[] chars, int cIndex, int count) {
        if (count < 10) {
            char x = (char) (count + '0');
            chars[index++] = chars[cIndex];
            chars[index++] = x;
        } else {
            chars[index++] = chars[cIndex];
            String s = String.valueOf(count);
            for (int j = 0; j < s.length(); j++) {
                chars[index++] = s.charAt(j);
            }
        }
    }

}