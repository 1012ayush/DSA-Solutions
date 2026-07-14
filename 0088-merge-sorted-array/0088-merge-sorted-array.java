class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for the last initialized element in nums1
        int i = m - 1;
        // Pointer for the last element in nums2
        int j = n - 1;
        // Pointer for the very last index of nums1
        int k = m + n - 1;

        // While there are elements to compare
        while (j >= 0) {
            // If i is still within bounds and nums1[i] is larger
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                // Otherwise, take from nums2
                nums1[k--] = nums2[j--];
            }
        }
    }
}