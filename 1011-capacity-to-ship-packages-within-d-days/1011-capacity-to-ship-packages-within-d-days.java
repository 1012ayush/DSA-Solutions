class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0 ;
        int right = 0;
        for(int i = 0 ; i < weights.length ; i++){
            if(weights[i] > left ){
                left = weights[i];
            }
            right += weights[i];
        }
        
        int ans = Integer.MAX_VALUE ;
        while(left <= right){
            int mid = left + (right - left)/2;
            int totalDays = calculateWeight(weights , mid , days );
            if(totalDays <= days){
                ans = mid ;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans ;
    }
    public int calculateWeight(int[] weights , int mid , int days){
        int daysNeeded = 1 ;
        int currentShipWeight = 0;
        for(int i = 0 ; i < weights.length ; i++){
          if((currentShipWeight + weights[i]) > mid){ daysNeeded++ ;
           currentShipWeight = weights[i] ;
        }
        else{
            currentShipWeight += weights[i];
        }}
        return daysNeeded ;
    }
}