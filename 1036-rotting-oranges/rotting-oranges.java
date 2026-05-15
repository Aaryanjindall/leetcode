class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        int time = 0;
        int newrotten = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean changed = false;
            while(size-->0){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int i = 0 ; i < 4 ; i++){
                    int nr = r+dx[i];
                    int nc = c+dy[i];
                    if(nr>=0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] != 0){
                        if(grid[nr][nc] == 1){
                            grid[nr][nc] = 2;
                            newrotten++;
                            changed = true;
                            q.add(new int[]{nr,nc});
                        } 
                    }
                }

            }
            if(changed){
                time++;
            }
            
        }
        if(fresh == newrotten){
            return time;
        }
        return -1;

    }
}