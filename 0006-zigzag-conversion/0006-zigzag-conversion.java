class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int slen = s.length();
        char[] sc = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        boolean down = true;
        int count = 0;
        for(int i = 0; i < slen; i++) {
            sb[count].append(sc[i]);
            if(down) {
                if(count == numRows - 1) {
                    count--;
                    down = !down;
                } else {
                    count++;
                }
            } else {
                if(count == 0) {
                    count++;
                    down = !down;
                } else {
                    count--;
                }
            }
        }
        StringBuilder sa = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            sa.append(sb[i]);
        }
        return sa.toString();
    }
}