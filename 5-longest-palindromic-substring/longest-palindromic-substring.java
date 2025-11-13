class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int startpoint = -1;
        int maxlen = Integer.MIN_VALUE;
        int dp[][] = new int [n+1][n+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(solve(dp,s,i,j)==1){
                    int len = j-i+1;
                    if(len > maxlen){
                        maxlen = len;
                        startpoint = i;
                    }
                }
            }
        }
        return s.substring(startpoint,startpoint+maxlen);
    }
    private int solve(int dp[][] , String s , int i , int j){
        if(i > j){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = solve(dp,s,i+1,j-1);
        }

        return dp[i][j] = -1;
    }
}