class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        boolean flag = false;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(flag)break;
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    dfs(grid,vis,q,i,j);
                    flag = true;
                    break;
                }
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int curr[] = q.poll();
                int x = curr[0];
                int y = curr[1];
                for(int i = 0 ; i < 4 ; i++){
                    int nr = x+dx[i];
                    int nc = y+dy[i];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                        if(!vis[nr][nc]){
                            if(grid[nr][nc] == 1){
                                return steps;
                            }
                            vis[nr][nc] = true;
                            q.add(new int[]{nr,nc});
                        }
                        
                    }
                }
            }
            steps++;
        }
        return steps;

    }
    private void dfs(int[][] grid , boolean vis[][] , Queue<int[]> q , int i , int j){
        if(i<0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        if(vis[i][j]){
            return;
        }
        if(grid[i][j] == 0){
            return;
        }
        vis[i][j] = true;
        q.offer(new int[]{i,j});
        dfs(grid,vis,q,i+1,j);
        dfs(grid,vis,q,i-1,j);
        dfs(grid,vis,q,i,j+1);
        dfs(grid,vis,q,i,j-1);
    }
}