import java.util.*;
class Solution {
    public int maximumWidth(int[] planks) {
      
        Map<Integer, Integer> sumCounts = new HashMap<>();
        int n = planks.length;
        
        for (int i = 0; i < n; i++) {
            sumCounts.put(planks[i], sumCounts.getOrDefault(planks[i], 0) + 1);
            
            for (int j = i + 1; j < n; j++) {
                int sum = planks[i] + planks[j];
                sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
            }
        }
        
        Arrays.sort(planks);
        List<Map.Entry<Integer, Integer>> sortedHeights = new ArrayList<>(sumCounts.entrySet());
        sortedHeights.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        
        int maxWidth = 0;
        
        for (Map.Entry<Integer, Integer> entry : sortedHeights) {
            if (entry.getValue() <= maxWidth) {
                break; 
            }
            
            int target = entry.getKey();
            int left = 0;
            int right = n - 1;
            int width = 0;
            
            while (left <= right) {
                if (left == right) {
                    if (planks[left] == target) {
                        width++;
                    }
                    break;
                }
                
                if (planks[right] == target) {
                    width++;
                    right--;
                } else if (planks[right] > target) {
                    right--;
                } else {
                    int currentSum = planks[left] + planks[right];
                    
                    if (currentSum == target) {
                        width++;
                        left++;
                        right--;
                    } else if (currentSum < target) {
                        left++; 
                    } else {
                        right--; 
                    }
                }
            }
            maxWidth = Math.max(maxWidth, width);
        }
        return maxWidth;
    }
}  
    
