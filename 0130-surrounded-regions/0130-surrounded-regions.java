class Solution {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public void solve(char[][] board) {
        List<int[]> borderCells = new ArrayList<>();
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++) {
            if(board[i][0] == 'O'){
                borderCells.add(new int[]{i, 0});
            }
            if(board[i][col-1] == 'O'){
                borderCells.add(new int[]{i, col - 1});
            }
        }

        for(int j = 0 ; j < col; j++) {
            if(board[0][j] == 'O'){
                borderCells.add(new int[]{0, j});
            }
            if(board[row - 1][j] == 'O'){
                borderCells.add(new int[]{row - 1, j});
            }
        }
        for(int[] cell: borderCells) {
            int i = cell[0];
            int j = cell[1];
            if(board[i][j] == 'O') {
                dfs(i,j, board);
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'a') board[i][j] = 'O';
            }
        }
    }

    void dfs(int i, int j, char[][] board) {
        board[i][j] = 'a';
        for(int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if(ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length && board[ni][nj] == 'O') {
                dfs(ni, nj, board);
            }
        }
    }
}