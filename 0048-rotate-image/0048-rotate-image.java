class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int r1 = 0;
        int r2 = row - 1;
        int temp;
        while(r1 < r2) {
            for(int i = 0; i < col; i++) {
                temp = matrix[r1][i];
                matrix[r1][i] = matrix[r2][i];
                matrix[r2][i] = temp;
            }
            r1++;
            r2--;
        }

        for (int r = 0; r < row; r++) {
            for(int c = r + 1; c < col; c++) {
                temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp; 
            }
        }


    }
}