class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int j = 0 ; j < cols ; j++){
            if(grid[0][j] == 1)dfs(grid,rows,cols,0,j);
            if(grid[rows-1][j] == 1)dfs(grid,rows,cols,rows-1,j);
        }
        for(int i = 0 ; i < rows ; i++){
            if(grid[i][0] == 1)dfs(grid,rows,cols,i,0);
            if(grid[i][cols-1] == 1)dfs(grid,rows,cols,i,cols-1);
        }

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;

    }
    private void dfs(int [][] grid , int r , int c , int i , int j){
        if(i < 0 || i >= r || j < 0 || j >= c)return;
        if(grid[i][j] == 0)return;
        grid[i][j] = 0;
        dfs(grid,r,c,i-1,j);
        dfs(grid,r,c,i,j-1);
        dfs(grid,r,c,i,j+1);
        dfs(grid,r,c,i+1,j);

    }
}