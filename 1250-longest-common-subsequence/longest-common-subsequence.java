class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int dp [][] = new int[1001][1001];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int n = s1.length();
        int m = s2.length();
        return solve(dp,s1,s2,0,0);
    }
    private int solve(int dp[][] , String s1 , String s2 , int i , int j){
        if(i == s1.length() || j == s2.length()){
            return dp[i][j] = 0;
        }
        if(dp[i][j] != -1)return dp[i][j];
        if((s1.charAt(i)) == s2.charAt(j)){
            return dp[i][j] = 1 + solve(dp,s1,s2,i+1,j+1);
        }

        return dp[i][j] = Math.max(solve(dp,s1,s2,i+1,j),solve(dp,s1,s2,i,j+1));



    }
}