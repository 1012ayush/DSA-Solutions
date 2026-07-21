class Solution {
    public int reversePairs(int[] nums) {
        return (int) mergeSort(nums, 0, nums.length - 1);
    }

    // Function to divide the array and count reverse pairs
    public static long mergeSort(int[] arr, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort left half & count reverse pairs within it
            count += mergeSort(arr, left, mid);

            // Sort right half & count reverse pairs within it
            count += mergeSort(arr, mid + 1, right);

            // Count cross-pairs between the two sorted halves
            count += countPairs(arr, left, mid, right);

            // Merge both halves back together in sorted order
            merge(arr, left, mid, right);
        }
        return count;
    }

    // Function to count cross-pairs using a two-pointer approach
    public static long countPairs(int[] arr, int left, int mid, int right) {
        long count = 0;
        int r = mid + 1;
        
        for (int i = left; i <= mid; i++) {
            // While right pointer is within bounds and satisfies the condition
            // Cast to long to prevent integer overflow during multiplication by 2
            while (r <= right && (long) arr[i] > 2 * (long) arr[r]) {
                r++;
            }
            // Add all valid elements found for the current arr[i]
            count += (r - (mid + 1));
        }
        return count;
    }

    // Standard function to merge two sorted arrays
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;

        // Merge the temp arrays in ascending order
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}