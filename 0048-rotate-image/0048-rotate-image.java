class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int r1 = 0;
        int c1 = 0;
        int r2= row - 1;
        int c2 = col - 1;
        while(r1 < r2) {
            for(int i = c1; i < c2; i++){
                int a = matrix[r1][i];
                int b = matrix[i][c2];
                int c = matrix[r2][c2 - (i-c1)];
                int d = matrix[r2-(i-c1)][c1];
                matrix[r1][i] = d;
                matrix[i][c2] = a;
                matrix[r2][c2 - (i-c1)] = b;
                matrix[r2-(i-c1)][c1] = c;
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
    }
}