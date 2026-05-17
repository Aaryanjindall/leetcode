class Solution {
    public int minInsertions(String s){
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(dp,s,0,s.length()-1);
    }
    private int solve(int dp[][] , String s , int i , int j){
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = solve(dp,s,i+1,j-1);
        }

        return dp[i][j] = 1+Math.min(solve(dp,s,i+1,j),solve(dp,s,i,j-1));
        
    }
}