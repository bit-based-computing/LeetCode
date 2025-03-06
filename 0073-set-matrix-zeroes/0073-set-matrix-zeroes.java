class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean hasZeroInFirstRow = false;
        boolean hasZeroInFirstCol = false;
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                hasZeroInFirstRow = true;
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                hasZeroInFirstCol = true;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                for (int k = 0; k < row; k++) {
                    matrix[k][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int k = 0; k < col; k++) {
                    matrix[i][k] = 0;
                }
            }
        }

        if (hasZeroInFirstRow) {
            for (int k = 0; k < col; k++) {
                matrix[0][k] = 0;
            }
        }

        if (hasZeroInFirstCol) {
            for (int k = 0; k < row; k++) {
                matrix[k][0] = 0;
            }
        }

    }
}