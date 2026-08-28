class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    /*    int n = matrix.length;
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
        return false ; */

        int n = matrix.length ;
        int m= matrix[0].length;
        for(int i = 0 ; i < n ;i++){
            if(matrix[i][0] <= target && target <= matrix[i][m - 1]){
                boolean found = binarySearch(matrix[i] , target);
                if(found){
                    return true ;
                }
            }
        }
        return false;
        }
        public boolean binarySearch(int[]row, int target){
            int left = 0 ; int right = row.length - 1;
            while(left <= right){
                int mid = left + (right - left)/2 ;
                if(row[mid] == target){
                    return true;
                }
                else if (row[mid] > target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            return false ;
        }
    }
