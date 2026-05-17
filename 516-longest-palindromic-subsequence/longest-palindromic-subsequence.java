class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[1000][1000];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(dp,0,s.length()-1,s);
    }
    private int solve(int dp[][] , int i , int j , String s){
        if(i>j){
            return 0;
        }
        if(i == j){
            return dp[i][j] = 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2+solve(dp,i+1,j-1,s);
        }
        return dp[i][j] = Math.max(solve(dp,i+1,j,s),solve(dp,i,j-1,s));
    }
}