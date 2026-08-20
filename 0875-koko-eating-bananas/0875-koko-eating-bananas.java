class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0 ;
        for(int i = 0 ; i < piles.length ; i++){
            right = Math.max(right , piles[i]);
        }
        int ans = Integer.MAX_VALUE ;

        while(left <= right){
            int mid = left + (right - left)/2 ;
            long hours = calculateHours(piles , mid);
               if(hours <= h){
                ans = mid ;
                right = mid - 1;
               }
                else{
                    left = mid + 1;
                }    
            
        }
        return ans ;

}
public long calculateHours(int[]piles ,int speed){
    long totalHours = 0;
    for(int i = 0 ; i <piles.length ; i++){
        totalHours += Math.ceil((double) piles[i] / (double) speed);
    }
    return totalHours ;
}
}