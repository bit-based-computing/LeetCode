class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], ' ');
        dfs(0, board, results);
        return results;
    }

    void dfs(int row, char[][] board, List<List<String>> results) {
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                StringBuilder sb = new StringBuilder();
                for (char c : r) {
                    sb.append(c == ' ' ? '.' : c);
                }
                solution.add(sb.toString());
            }
            results.add(solution);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (board[row][col] == ' ') {
                // Place Queen
                board[row][col] = 'Q';

                // Track filled cells to revert later
                List<int[]> changed = new ArrayList<>();
                markThreats(row, col, board, '.', changed);

                dfs(row + 1, board, results);

                // Backtrack
                board[row][col] = ' ';
                for (int[] cell : changed) {
                    board[cell[0]][cell[1]] = ' ';
                }
            }
        }
    }

    void markThreats(int x, int y, char[][] board, char c, List<int[]> changed) {
        int n = board.length;

        // Left/Right (row)
        for (int j = 0; j < n; j++) {
            if (j != y && board[x][j] == ' ') {
                board[x][j] = c;
                changed.add(new int[]{x, j});
            }
        }

        // Up/Down (column)
        for (int i = 0; i < n; i++) {
            if (i != x && board[i][y] == ' ') {
                board[i][y] = c;
                changed.add(new int[]{i, y});
            }
        }

        // Top-left to bottom-right
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == ' ') {
                board[i][j] = c;
                changed.add(new int[]{i, j});
            }
        }
        for (int i = x + 1, j = y + 1; i < n && j < n; i++, j++) {
            if (board[i][j] == ' ') {
                board[i][j] = c;
                changed.add(new int[]{i, j});
            }
        }

        // Top-right to bottom-left
        for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == ' ') {
                board[i][j] = c;
                changed.add(new int[]{i, j});
            }
        }
        for (int i = x + 1, j = y - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == ' ') {
                board[i][j] = c;
                changed.add(new int[]{i, j});
            }
        }
    }
}
