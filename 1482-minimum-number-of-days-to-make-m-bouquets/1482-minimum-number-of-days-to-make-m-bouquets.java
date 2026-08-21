class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < bloomDay.length ; i++){
            right = Math.max(right , bloomDay[i]) ;
        }
        while( left <= right){
            int mid = left + (right - left)/2 ;
            long bouqets = calculateFlower(bloomDay , mid , k);
            if(bouqets >= m){
                ans =  mid ;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans ;
    }
    public long calculateFlower(int[] bloomDay , int mid, int k ){
        int consecutiveFlowers = 0;
        long bouqetMade = 0;
        for(int i = 0 ; i < bloomDay.length ; i++){
            if(bloomDay[i] <= mid){
                consecutiveFlowers++ ;
                if(consecutiveFlowers == k){
                    bouqetMade += 1;
                     consecutiveFlowers = 0;
                }
                
            }
            else{
                consecutiveFlowers = 0;
            }
        }
        return bouqetMade ;
    }
}