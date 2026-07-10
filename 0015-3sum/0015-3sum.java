import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort the array so we can handle duplicates and use two-pointers
        Arrays.sort(nums);
        
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            // 2. Skip duplicate values for 'i' to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 3. Skip duplicate values for 'left' and 'right'
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // Move pointers inward
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, move left pointer to increase sum
                    left++;
                } else {
                    // Sum is too large, move right pointer to decrease sum
                    right--;
                }
            }
        }
        return result;
    }
}