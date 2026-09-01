class Solution {
    public int maxDepth(String s) {
        int balance = 0;
       int maxDepth  = 0;
         for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                balance++ ;
                 maxDepth = Math.max(maxDepth ,balance);
            }
            else if(s.charAt(i) == ')'){
                balance-- ;
                
            }
         }
         return maxDepth ;

    }
}