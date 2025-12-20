class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});//time, row ,col;
        int dist[][] = new int[n][n];
        for(int row[] : dist){
            Arrays.fill(row,(int)1e9);
        }
        
        dist[0][0] = grid[0][0];
        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int time = top[0];
            int r = top[1];
            int c = top[2];
            
            if(r == n-1 && c == n-1){
                break;
            }
            dfs(grid,n,r+1,c,time,pq,dist);
            dfs(grid,n,r-1,c,time,pq,dist);
            dfs(grid,n,r,c+1,time,pq,dist);
            dfs(grid,n,r,c-1,time,pq,dist);
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(dist[i][j]);
            }
            System.out.println();
        }
        return dist[n-1][n-1];

    }
    private void dfs(int[][]grid , int n , int nr , int nc , int t , PriorityQueue<int[]>pq , int dist[][]){
        if(nr >= 0  && nc >= 0 && nr < n && nc < n){
            int nexttime = Math.max(t,grid[nr][nc]);
            if(nexttime < dist[nr][nc]){
                dist[nr][nc] = nexttime;
                pq.add(new int[]{nexttime,nr,nc});
            }
            
        }
    }
}