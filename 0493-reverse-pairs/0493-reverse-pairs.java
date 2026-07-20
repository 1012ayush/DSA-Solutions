class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        
        // Count pairs in left half + right half + cross-pairs between halves
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        count += countPairs(nums, left, mid, right);
        
        // Merge the sorted halves back together
        merge(nums, left, mid, right);
        
        return count;
    }

    private int countPairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int r = mid + 1;
        
        // For each element in the left half, find how many elements in the right half satisfy nums[i] > 2 * nums[r]
        for (int i = left; i <= mid; i++) {
            while (r <= right && (long) nums[i] > 2 * (long) nums[r]) {
                r++;
            }
            count += (r - (mid + 1));
        }
        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        // Standard merge step to keep the array sorted
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy sorted elements back into the original array
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }
}