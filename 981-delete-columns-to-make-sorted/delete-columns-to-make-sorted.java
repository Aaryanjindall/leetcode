class Solution {
    public int minDeletionSize(String[] strs) {
        char s = 'a';
        int ch = (int)s;
        // return ch;
        int n = strs.length;
        int m = strs[0].length();
        
        // char [][] board = new char[n][m];
        // for(String str : strs){
        //     char []
        // }
        int del = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n-1 ; j++){
                if((int)strs[j].charAt(i) > (int)strs[j+1].charAt(i)){
                    del++;
                    break;//agr ek column mai milgya toh dubara del++ kyu karna 
                }
            }
        }
        return del;


    }
}