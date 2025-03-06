class Solution {
    void setZero(int[] freq) {
        for(int i = 0; i < 9; i++)
            freq[i] = 0;
    }
    public boolean isValidSudoku(char[][] board) {
        int[] freq = new int[9];
        int index = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    index = board[i][j] - '1';
                    if(freq[index] > 0) return false;
                    freq[index]++;
                }
            }
            setZero(freq);
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.') {
                    index = board[j][i] - '1';
                    if(freq[index] > 0) return false;
                    freq[index]++;
                }
            }
            setZero(freq);
        }

        for(int i = 0; i < 9; i++) {
            if(i % 3 == 0) setZero(freq);
            for(int j = 0; j < 3; j++) {
                if(board[i][j] != '.') {
                    index = board[i][j] - '1';
                    if(freq[index] > 0) return false;
                    freq[index]++;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            if(i % 3 == 0) setZero(freq);
            for(int j = 3; j < 6; j++) {
                if(board[i][j] != '.') {
                    index = board[i][j] - '1';
                    if(freq[index] > 0) return false;
                    freq[index]++;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            if(i % 3 == 0) setZero(freq);
            for(int j = 6; j < 9; j++) {
                if(board[i][j] != '.') {
                    index = board[i][j] - '1';
                    if(freq[index] > 0) return false;
                    freq[index]++;
                }
            }
        }
        
        return true;
    }
}