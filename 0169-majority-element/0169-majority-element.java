// import java.util.HashMap ;
class Solution {
    public int majorityElement(int[] nums) {
       int n = nums.length ;
  /*      for(int i = 0 ; i < nums.length ; i++){
             int count = 0;
             for(int j = 0 ; j < n ; j++){
                if(nums[j] == nums[i]){
                    count++ ;
                }}
                if(count > n /2){
                    return nums[i];
                }
        }
        return -1 ;  */
     /*   HashMap<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num ,map.getOrDefault(num , 0)+1 );
            if(map.get(num) > n/2){
                return num;
            }
        }
        return -1;   */
        int count = 0;
        int element = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(count == 0){
                count = 1;
                element = nums[i];
            }
            else if(nums[i] == element){
                count++ ;
            }
            else{
                count-- ;
            }
        }
        return element ;
    }
}