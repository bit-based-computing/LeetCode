class Solution {
    boolean isValid(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
    public void gameOfLife(int[][] board) {
        int[]dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[]dy = {-1,-1, 0, 1, 1, 1, 0, -1};
        int row = board.length;
        int col = board[0].length;
        int x = 0;
        int y = 0;
        int liveCount = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                liveCount = 0;
                for(int k = 0; k < 8; k++) {
                    x = i + dx[k];
                    y = j + dy[k];
                    if(isValid(x,y,row,col) && Math.abs(board[x][y]) == 1){
                        liveCount++;
                    }
                }
                if(board[i][j] == 1 && liveCount < 2) {
                    board[i][j] = -1;
                } else if(board[i][j] == 1 && liveCount > 3){
                    board[i][j] = -1;
                } else if(board[i][j] == 0 && liveCount == 3){
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == -1) board[i][j] = 0;
                else if(board[i][j] == 2) board[i][j] = 1;
            }
        }

    }
}