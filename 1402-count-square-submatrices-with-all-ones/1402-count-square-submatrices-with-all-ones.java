class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == 1) {
                    count++;
                    int ni = i;
                    int nj = j;
                    boolean isValid = true;
                    while(ni + 1 < row && nj + 1 < col) {
                        ni = ni + 1;
                        nj = nj + 1;
                        isValid = true;

                        for(int k = j; k <= nj; k++) {
                            if(matrix[ni][k] == 0) {
                                isValid = false;
                                break;
                            }
                        }

                        for(int k = i; k <= ni; k++) {
                            if(matrix[k][nj] == 0) {
                                isValid = false;
                                break;
                            } 
                        }
                        if(!isValid) break;
                        count++;
                    }
                }
                
            }
        }

        return count;
    }
}