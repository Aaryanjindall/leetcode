class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp [][] = new int [n+1][n+1];
        int maxlen = Integer.MIN_VALUE;
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return solve(dp,s,0,n-1);
    }
    private int solve(int dp[][] , String s , int i , int j){
        if(i > j){
            return 0;
        }
        if(i==j){
            return dp[i][j] = 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + solve(dp,s,i+1,j-1);
        }
        return dp[i][j] = Math.max(solve(dp,s,i+1,j),solve(dp,s,i,j-1));
    }
}
