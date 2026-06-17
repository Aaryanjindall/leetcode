class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int st = -1;
        int maxlen = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(solve(dp,i,j,s) == 1){
                    int len = j-i+1;
                    if(len > maxlen){
                        st = i;
                        maxlen = len;
                    }
                }
            }
        }
        return s.substring(st,st+maxlen);
    }
    private int solve(int dp[][] , int i , int j , String s){
        if(i>j){
            return 1;
        }
        if(i == j){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = solve(dp,i+1,j-1,s);
        }
        return dp[i][j] = -1;
    }
}