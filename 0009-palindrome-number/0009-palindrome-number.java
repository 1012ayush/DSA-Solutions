class Solution {
    public boolean isPalindrome(int x) {
         if (x < 0) return false;
 /*       String str = String.valueOf(x);
        int n = str.length();
       for(int i = 0 ; i < n/2 ; i++){
        if(str.charAt(i) != str.charAt(n-1-i)){
            return false;
        }
       
       } 
       return true; */

       int original = x;
       long reversed = 0;
       while(x != 0){
      reversed =   (reversed * 10) + (x %10) ;
        x = x/10;
       }
       return original == reversed ;
    }
}