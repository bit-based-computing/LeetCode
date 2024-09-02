class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length-1;
        int col = matrix[0].length-1;

        int r = 0;
        while(r <= row/2) {

            //--->
            for(int c = r; c <= col - r; c++) {
                ans.add(matrix[r][c]);
            }

            /*
                |
                |
                >

            */
            for(int i = r+1; i < row - r && col-r >= r ; i++) {
                ans.add(matrix[i][col - r]);
            }

            // <---
            for(int c = col - r; row - r > r  && c >= r; c--){
                ans.add(matrix[row-r][c]);
            }


            /*
            >
            |
            |
            */

            for(int i = row-r-1; i > r && r < col-r; i--) {
                ans.add(matrix[i][r]);
            }

            r++;
        }
        return ans;
    }
}