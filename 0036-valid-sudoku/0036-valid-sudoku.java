class Solution {
    void setZero(int[] freq) {
        for (int i = 0; i < 9; i++)
            freq[i] = 0;
    }

    boolean isValid(int col, char[][] board, int[] freq) {
        int index = 0;
        for (int i = 0; i < 9; i++) {
            if(i % 3 == 0) setZero(freq);
            for (int j = col; j < col + 3; j++) {
                if (board[j][i] != '.') {
                    index = board[j][i] - '1';
                    if (freq[index] > 0)
                        return false;
                    freq[index]++;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int[] freq = new int[9];
        int index = 0;

        //check rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    index = board[i][j] - '1';
                    if (freq[index] > 0)
                        return false;
                    freq[index]++;
                }
            }
            setZero(freq);
        }

        // check column
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    index = board[j][i] - '1';
                    if (freq[index] > 0)
                        return false;
                    freq[index]++;
                }
            }
            setZero(freq);
        }

        //check 3 * 3 grids
        if (!isValid(0, board, freq))
            return false;
        if (!isValid(3, board, freq))
            return false;
        if (!isValid(6, board, freq))
            return false;
        return true;
    }
}