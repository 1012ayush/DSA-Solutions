class Solution {
    public int reverse(int x) {
        long  longReversed = 0;
       while(x != 0){
       int lastDigit = x%10;
       longReversed = longReversed * 10 + lastDigit ;
       x = x / 10 ;   }

       if (longReversed > Integer.MAX_VALUE || longReversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) longReversed ;

    }

}