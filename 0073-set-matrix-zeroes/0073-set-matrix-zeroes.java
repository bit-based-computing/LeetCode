class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean hasFirstRow = false;
        boolean hasFirstCol = false;
        for (int c = 0; c < col; c++) {
            if (matrix[0][c] == 0) hasFirstRow = true;
        }
        for (int r = 0; r < row; r++) {
            if(matrix[r][0] == 0) hasFirstCol = true;
        }

        for (int r = 1; r < row; r++) {
            for(int c = 1; c < col; c++) {
                if(matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        for (int c = 1; c < col; c++) {
            if (matrix[0][c] == 0) nullifyColumn(c, matrix);
        }

        for (int r = 1; r < row; r++){
            if(matrix[r][0] == 0) nullifyRow(r, matrix);
        }

        if (hasFirstRow) {
            for (int c = 0; c < col; c++) matrix[0][c] = 0;
        }
        if (hasFirstCol) {
            for(int r = 0; r < row; r++) matrix[r][0] = 0;
        }

    }

    private void nullifyColumn(int col, int[][] matrix) {
        int row = matrix.length;
        for(int r = 1; r < row; r++) matrix[r][col] = 0;
    }

    private void nullifyRow(int row, int[][] matrix) {
        int col = matrix[0].length;
        for(int c = 1; c < col; c++) matrix[row][c] = 0;
    }
}