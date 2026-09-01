class Solution {
    public String reverseWords(String s) {/* // \\s+ we used is the regex as s is used for one whitespace but \\s+ means many whitespaces a regex thing . 
        String[]  words = s.trim().split("\\s+"); //s.trim trims the edges spaces and in between if we find the spaces it deals with the split and the the , sky , is , blue is now separate words and letter we reversing and appending by using the StringBuilder.
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0 ; i--){
           sb.append(words[i]);
           if(i > 0){
            sb.append(" "); // here it inserts spaces after the every word but it don't want to insert space after the last word which is our first word .
           }
        }
        return sb.toString() ; */

        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0){
            while(i >= 0 && s.charAt(i)==' '){
                i-- ;
            }
            if(i < 0){
                break;
            }
            int right = i;
            while(i >= 0 && s.charAt(i) != ' '){
                i-- ;
            }
            int left = i + 1;

            if(sb.length() > 0){
                sb.append(' ');
            }
            sb.append(s.substring(left , right + 1));
        }
        return sb.toString();
    }
}