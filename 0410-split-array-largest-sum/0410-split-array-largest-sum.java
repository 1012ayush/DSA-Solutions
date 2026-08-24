class Solution {
    public int splitArray(int[] nums, int k) {
        if(k > nums.length ){
            return -1;
        }
        int left = 0;
        int right = 0;
        int ans = -1 ;
        for(int i = 0 ; i < nums.length ; i++){
            left = Math.max(left , nums[i]);
            right += nums[i];
        }
        while(left <= right){
            int mid = left + (right - left)/2 ;
            if(LargestSum(nums , mid , k)){
                ans = mid ;
                right = mid - 1;
            }
            else{
            left = mid + 1;
        }
        
    }
    return ans ;
    }
    public boolean LargestSum(int[] nums , int mid , int k ){
        int numberAssigned = 1;
        int current = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] >mid){
                return false ;
            }
            if(current + nums[i] > mid ){
                numberAssigned++ ;
                current = nums[i] ;
            }
            else{
                current = current + nums[i] ;
            }
        }
        return numberAssigned <= k ;
    }
}