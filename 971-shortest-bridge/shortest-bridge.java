class Solution {
    int steps = 0;
    public int shortestBridge(int[][] grid) {
        // return 1;
        int n = grid.length;
        boolean vis[][] = new boolean[n][n];
        outer:
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    dfs(grid,vis,i,j);
                    break outer;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(vis[i][j]){
                    q.add(new int[]{i,j});
                }
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int k = 0 ; k < 4 ; k++){
                    int nr = r + dx[k];
                    int nc = c + dy[k];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < n && !vis[nr][nc]){
                    if(grid[nr][nc] == 1){
                        return steps;
                    }
                    vis[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                    
                }
                }
            }
            steps++;
        }
        

        return -1;

    }
    private void dfs(int[][]grid , boolean vis[][] , int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid.length || vis[i][j] || grid[i][j] == 0){
            return;
        }
        vis[i][j] = true;
        dfs(grid,vis,i+1,j);
        dfs(grid,vis,i,j+1);
        dfs(grid,vis,i-1,j);
        dfs(grid,vis,i,j-1);
    }
    
}