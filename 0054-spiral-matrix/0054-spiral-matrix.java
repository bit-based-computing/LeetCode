class Solution {
    int row = 0;
    int col = 0;
    void spiralMove(int[][] matrix, int i, int j, List<Integer> ans, String moveTo) {
        int oi = i;
        int oj = j;
        if(moveTo.equals("forward")) {
            if(j + 1 <= col && matrix[i][j+1] != -101) {
                j++;
            } else if(i + 1 <= row && matrix[i+1][j] != -101){
                i++;
                moveTo = "down";
            }
        } else if(moveTo.equals("down")) {
            if(i + 1 <= row && matrix[i+1][j] != -101) {
                i++;
            } else if(j - 1 >= 0 && matrix[i][j - 1] != -101){
                j--;
                moveTo = "backward";
            }
        } else if(moveTo.equals("backward")) {
            if(j - 1 >= 0 && matrix[i][j-1] != -101) {
                j--;
            } else if(i - 1 >= 0 && matrix[i - 1][j] != -101){
                i--;
                moveTo = "up";
            }
        } else if(moveTo.equals("up")) {
            if(i - 1 >= 0 && matrix[i-1][j] != -101) {
                i--;
            } else if(j + 1 <= col && matrix[i][j+1] != -101){
                j++;
                moveTo = "forward";
            }
        }
        if(oi != i || oj != j) {
            ans.add(matrix[i][j]);
            matrix[i][j] = -101;
            spiralMove(matrix, i, j, ans, moveTo);
        }
        
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        row = matrix.length - 1;
        col = matrix[0].length - 1;
        ans.add(matrix[0][0]);
        matrix[0][0] = -101;
        spiralMove(matrix, 0, 0, ans, "forward");
        return ans;
    }
}