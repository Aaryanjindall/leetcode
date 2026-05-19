class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(dp,m,n,0,0);
    }
    private int solve(int [][]dp , int m , int n , int i , int j){
        if(i >= m || j >= n){
            return 0;
        }
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = solve(dp,m,n,i,j+1);
        int down = solve(dp,m,n,i+1,j);
        return dp[i][j] = right+down;
    }
}