class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[256];

        for(int i = 0 ; i <s.length() ; i++){
            count[s.charAt(i)]++ ;
        }
        for(int i = 0  ; i < s.length() ; i++){
            int maxCount = 0;
            int maxChar = 0;

            for(int j = 0 ; j < 256 ; j++){
                if(count[j] > maxCount){
                    maxCount = count[j];
                    maxChar = j;
                }
            }
            if(maxChar == 0){
            break ;
        }
        for(int k = 0 ; k < maxCount ; k++){
            sb.append((char) maxChar);
        }
         i += maxCount - 1;
         count[maxChar] = 0;
        }

        return sb.toString();
    }
}