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
       /* here we are defining the target that's why we know our boundaries and they are 0 and m   */
        int m = nums1.length;
        int n = nums2.length;
        int left = 0; // contains strting 
        int right = m ; // contains ending 
        while(left <= right){
            int cut1 = left + (right - left)/2;  // FIND A MID HERE AND WILL FIND THE L1 ON THE LEFT OF MID AND R1 ON THE RIGHT OF THE MID (1 ELEMENT ON BOTH SIDE )
            int cut2 = (m + n + 1)/2 - cut1 ; // SO IF WE HAVE TO TAKE 5 NUMBERS AND FROM NUM1 WE ARE TAKING 2 ELEMENTS THEN WE SHOULD TAKE 3 ELEM. FROM THE NUMS2 AND . 

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE :nums1[cut1 - 1]; 
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 <= r2 && l2 <= r1){
                if((m + n) % 2 != 0){
                    return Math.max(l1 , l2); // LET SUPPOSE WE HAVE 9 ELEMENTS TOTAL AND OUR MID WILL BE  9 + 1 / 2 = 5 SO 5 WILL BE THE HIGHEST NO . OF LEFT SIDE 
                }
                else{
                    return (Math.max(l1 , l2) + Math.min(r1 , r2))/2.0 ; // HERE WE FIND THE MAX AS PREVIOUS BUT ON THE RIGHT OF M+ N + 1/ 2 IS SMALLEST RIGHT ELEMENT SO WE FIND IT AND ADD BOTH AND FIND THE MEDIAN OF IT .
                }
            }
            else if(l1 > r2){
               right = cut1 - 1; 
            } // IF L1 > R2 MEANS LEFT SIDE IS TRAITOR AND HAS GREATER ELEMENT THAN RIGHT SIDE IN THE LEFT SIDE SO WE TAKE FEW ELEMENTS FROM THE LEFT SIDE , AND INCREASE THE NO . OF ELEMENT TO TAKE FROM THE ARRAY 2 . 
            else{
                left = cut1 + 1;
            }
        }
        return 0.0 ;
} }