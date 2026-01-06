class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n+1][m+1];
        for(int num[] : dp){
            Arrays.fill(num,-1);
        }
        return solve(grid,dp,0,0,n,m);
    }
    private int solve(int [][] grid , int dp[][] , int i , int j, int n,int m){
        if(i >= n || j >= m){
            return Integer.MAX_VALUE;
        }
        if(i == n-1 && j == m-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = solve(grid,dp,i,j+1,n,m);
        int down  = solve(grid,dp,i+1,j,n,m);

        return dp[i][j] = grid[i][j]+Math.min(right,down);
    }
}