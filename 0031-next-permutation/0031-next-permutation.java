class Solution {
    public void nextPermutation(int[] nums) {
    /*    int n = nums.length;
        int i = n-2 ;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i-- ;
        }
        if(i >= 0){
            int j = n-1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums , i , j);
        }
        reverse(nums , i+1 , n-1);
    }
    private void reverse(int[] nums , int left , int right){
        while(left < right){
            swap(nums , left , right);
            left++; right--;
        }
    }
    private void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp ;  */

        int n = nums.length;
        int pivot = -1;

        // FIX: Changed i++ to i--
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }
        
        reverse(nums, pivot + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
