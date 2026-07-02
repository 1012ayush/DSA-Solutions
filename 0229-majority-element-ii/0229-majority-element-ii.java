class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int v1 = 0;int v2 = 1;
        int ct1 = 0; int ct2 = 0;
        for(int num : nums){
            if(num == v1)ct1++ ;
            else if(num == v2 )ct2++ ;
            else if(ct1 == 0){
                v1 = num ;
                ct1 = 1;
            }
            else if(ct2 == 0){
                v2 = num ;
                ct2 = 1;
            }
            else{
                ct1-- ; 
                ct2-- ;
            }
        }
        ct1 = 0 ; ct2 = 0;
        for(int num : nums){
            if(num == v1)ct1++ ;
            else if(num == v2)ct2++ ;
        }
        List<Integer>res = new ArrayList<>();
        if(ct1 > n/3)res.add(v1);
        if(ct2 > n/3)res.add(v2);
        return res ;
    }
}