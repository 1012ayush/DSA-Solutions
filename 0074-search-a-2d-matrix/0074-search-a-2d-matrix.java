class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    /*    int n = matrix.length;
        int m = matrix[0].length;
        int rows = 0;
        int col = m - 1;
        boolean ans = false ;
        while(rows < n && col >= 0){
        if(matrix[rows][col] == target){
            return true ;
        }
        else if(matrix[rows][col] > target){
            col-- ;
        }
        else{
            rows++ ;
        } }
return ans ; */

int n = matrix.length;
int m = matrix[0].length;
int left = 0;
int right = (m * n) - 1 ;
while(left <= right){
    int mid = left + (right - left)/2;
    int row = mid/m ;
    int col = mid%m ;
    int midValue = matrix[row][col];
    if(midValue == target){
        return true;
    }
    else if ( midValue > target){
        right = mid - 1;
    }
    else{
        left = mid + 1;
    }
}
return false ;

    }
}