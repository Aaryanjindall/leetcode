class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxgold = 0;
        boolean vis[][] = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] != 0){
                    int gold = dfs(grid,vis,i,j,n,m);
                    maxgold = Math.max(gold,maxgold);
                }
            }
        }
        return maxgold;
    }
    private int dfs(int [][]grid , boolean vis[][] , int i , int j , int n , int m){
        if(i<0 || j < 0 || i > n-1 || j > m-1 || grid[i][j] == 0){
            return 0;
        }
        if(vis[i][j]){
            return 0;
        }
        vis[i][j] = true;
        int left = grid[i][j]+dfs(grid,vis,i-1,j,n,m);
        int right = grid[i][j]+dfs(grid,vis,i+1,j,n,m);
        int top = grid[i][j]+dfs(grid,vis,i,j-1,n,m);
        int bottom = grid[i][j]+dfs(grid,vis,i,j+1,n,m);
        int gold = Math.max(Math.max(left,right),Math.max(top,bottom));
        vis[i][j] = false;
        return gold;
        
    }
}