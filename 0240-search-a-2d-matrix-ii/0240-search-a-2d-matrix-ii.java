class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
       
        int rows = 0;
        int cols = m - 1;
        while(rows < n && cols >= 0 ){
            if(matrix[rows][cols] == target){
                return true;
            }
            else if(matrix[rows][cols] > target){
                cols-- ;
            }
            else{
                rows++ ;
            }
        }
        return false ;
        }
    }
