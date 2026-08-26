 /* class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length ;
        int n2 = nums2.length;
        int totalLength = n1 + n2 ;

        int[] merged = new int[totalLength];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n1 && j < n2){
            if(nums1[i] <= nums2[j]){
                merged[k] = nums1[i];
                i++;
            }
            else{
                merged[k] = nums2[j];
                j++ ;
            }
            k++ ;
        }
        while( i < n1){
            merged[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n2){
            merged[k] = nums2[j];
            j++ ;
            k++ ;
        }
        int mid = totalLength / 2;

        if(totalLength % 2 == 0){
            return (merged[mid - 1] + merged[mid]) / 2.0 ;
        }
        else{
            return merged[mid];
        }

    }
} */

class Solution{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
           return findMedianSortedArrays(nums2 , nums1) ;
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m ;
        while(left <= right){
            int cut1 = left + (right - left)/2;
            int cut2 = (m + n + 1)/2 - cut1 ;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE :nums1[cut1 - 1];
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 <= r2 && l2 <= r1){
                if((m + n) % 2 != 0){
                    return Math.max(l1 , l2);
                }
                else{
                    return (Math.max(l1 , l2) + Math.min(r1 , r2))/2.0 ;
                }
            }
            else if(l1 > r2){
               right = cut1 - 1; 
            }
            else{
                left = cut1 + 1;
            }
        }
        return 0.0 ;
} }