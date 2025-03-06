class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length - 1;
        int temp = 0;
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= row/2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][row - j];
                matrix[i][row - j] = temp;
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < row - i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[row - j][row - i];
                matrix[row - j][row - i] = temp;
            }
        }
    }
}