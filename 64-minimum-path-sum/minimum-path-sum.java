class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(grid,dp,0,0);
    }
    private int solve(int grid[][] , int dp[][] , int i , int j){
        if(i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = solve(grid,dp,i,j+1);
        int down = solve(grid,dp,i+1,j);
        
        return dp[i][j] = grid[i][j]+Math.min(right,down);
    }
}