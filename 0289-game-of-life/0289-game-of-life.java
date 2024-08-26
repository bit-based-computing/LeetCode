class Solution {
    int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0,};
    int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int liveCell = 0;
                for (int k = 0; k < 8; k++) {
                    int r = i + dr[k];
                    int c = j + dc[k];
                    if (isValid(r, c, row, col)) {
                        if (Math.abs(board[r][c]) == 1) {
                            liveCell++;
                        }
                    }
                }
                if ((liveCell < 2 || liveCell > 3) && board[i][j] == 1) {
                    board[i][j] = board[i][j] * -1;
                } else if(liveCell == 3 && board[i][j] == 0) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == -1) board[i][j] = 0;
                else if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
   
    private boolean isValid(int i, int j, int row, int col) {
        if(i < 0 || i >= row || j < 0 || j >= col) return false;
        return true;
    }
}