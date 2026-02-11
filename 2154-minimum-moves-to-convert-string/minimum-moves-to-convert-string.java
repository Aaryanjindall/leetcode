class Solution {
    public int minimumMoves(String s) {
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == 'X'){
                count++;
                i += 2;

            }
        }
        return count;
    }
}