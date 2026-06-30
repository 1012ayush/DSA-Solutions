// import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
    /*   Set<Integer> set = new LinkedHashSet<>();
       for(int num : nums){
        set.add(num);
        int index = 0;
       } 
       int index = 0;
       for(int num : set){
        nums[index++] = num;
       }
      return index ; */
      if(nums.length == 0)return 0;
      int j = 0;
      for(int i = 1 ; i <  nums.length ; i++){
        if(nums[i] != nums[j]){
            j++ ;
            nums[j] = nums[i] ;
        }
      }
      return j+1;
    }
    
}