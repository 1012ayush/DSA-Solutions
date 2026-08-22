class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        int ans = Integer.MAX_VALUE ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > right){
                right = nums[i];
            }
        }
        while(left <= right){
            int mid = left + (right - left)/2;
            int sum = calculateSum(nums , mid , threshold);
            if(sum <= threshold){
                ans = mid ;
                right = mid - 1;    
            }
            else{
                left = mid + 1;
            }
        }
        return ans ;
        
    }

    public int calculateSum(int[] nums , int mid , int threshold){
        int totalSum  = 0;
        for(int i = 0 ; i < nums.length ; i++){
           totalSum += (nums[i] + mid - 1)/ mid ;
        }
        return totalSum ;
    }
}