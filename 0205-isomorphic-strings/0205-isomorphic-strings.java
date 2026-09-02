class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] indexS = new int[256];
        int[] indexT = new int[256];

        for(int i = 0 ; i < s.length() ; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(indexS[c1] != indexT[c2]){
                return false ;
            }
            indexS[c1] = i + 1;
            indexT[c2] = i + 1;
        }
        return true ;
    }
}