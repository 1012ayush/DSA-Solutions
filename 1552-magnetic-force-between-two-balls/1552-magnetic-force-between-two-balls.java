import java.util.Arrays ; 
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position) ;
        int left = 0;
        int right = position[position.length - 1] - position[0];
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left)/2 ;
            if(canTwoBalls(position , m , mid )){
                ans = mid ; 
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans ;
    }
    public boolean canTwoBalls(int[] position , int m , int mid){
        int ballsPlaced = 1;
        int lastballsPosition = position[0];
        for(int i = 1 ; i < position.length ; i++){
            if(position[i] - lastballsPosition  >= mid){
                ballsPlaced++ ;
                lastballsPosition = position[i] ;
            }
            if(ballsPlaced ==  m){
                return true ;
            }
        }
        return false ;
    }
}