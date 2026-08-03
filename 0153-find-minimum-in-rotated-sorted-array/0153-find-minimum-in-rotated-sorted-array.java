class Solution {
    public int findMin(int[] nums) {
       int left = 0;
       int right = nums.length -1 ;
       int minVal = Integer.MAX_VALUE;
       while(left <= right){
        int mid = left + (right - left)/2;
        if(nums[left] <= nums[mid] ){
            
           minVal = Math.min(minVal , nums[left]);
           left = mid +1;
        }
        else{
           
            minVal = Math.min(minVal ,  nums[mid]);
            right = mid - 1;
        }
       } 
     return minVal ;
    }
}