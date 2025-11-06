class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxgold = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] != 0){
                    maxgold = Math.max(maxgold,dfs(grid,i,j));
                }
            }
        }

        return maxgold;

    }
    private int dfs(int grid[][] , int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int gold = grid[i][j];
        grid[i][j] = 0;
        int up = dfs(grid,i-1,j);
        int down = dfs(grid,i,j-1);
        int right = dfs(grid,i+1,j);
        int left = dfs(grid,i,j+1);

        grid[i][j] = gold;

        return gold + Math.max(Math.max(up,down),Math.max(right,left));
        
        

    }
}