class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row - 1;
        int targetRow = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(matrix[mid][col-1] == target) return true;
            if(matrix[mid][col-1] > target){
                targetRow = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(targetRow == -1) return false;
        
        low = 0;
        high = col - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(matrix[targetRow][mid] == target) return true;
            if(matrix[targetRow][mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}