class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int [text1.length()][text2.length()];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(text1,text2,0,0,dp);
    }
    private int solve(String t1 , String t2 , int i , int j , int dp[][]){
        if(i == t1.length() || j == t2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(t1.charAt(i) == t2.charAt(j)){
            return dp[i][j] = 1+solve(t1,t2,i+1,j+1,dp);
        }
        return dp[i][j] = Math.max(solve(t1,t2,i+1,j,dp),solve(t1,t2,i,j+1,dp));
    }
}