class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return solve(dp,m,n,0,0);
    }
    private int solve(int dp[][] , int m , int n , int i , int j){
        if(i>m-1 || j>n-1){
            return 0;
        }
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = solve(dp,m,n,i+1,j);
        int right = solve(dp,m,n,i,j+1);

        return dp[i][j] = right+down;
    }
}