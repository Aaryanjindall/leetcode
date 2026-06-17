class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(s,dp,0,n-1);
    }
    private int solve(String s , int dp[][] , int i , int j){
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
            return dp[i][j] = 2+solve(s,dp,i+1,j-1);
        }
        int left = solve(s,dp,i+1,j);
        int right = solve(s,dp,i,j-1);
        return dp[i][j] = Math.max(left,right);
    }
}