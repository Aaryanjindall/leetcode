class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        int dist[][] = new int [n][m];
        for(int di[] : dist){
            Arrays.fill(di,-1);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        dist[0][0] = 1;

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int row = curr[0];
            int col = curr[1];
            int d = dist[row][col];

            if(row == n-1 && col == m-1){
                return d;
            }

            add(grid,dist,q,row-1,col,d);
            add(grid,dist,q,row,col-1,d);
            add(grid,dist,q,row+1,col,d);
            add(grid,dist,q,row,col+1,d);
            add(grid,dist,q,row-1,col+1,d);
            add(grid,dist,q,row+1,col-1,d);
            add(grid,dist,q,row-1,col-1,d);
            add(grid,dist,q,row+1,col+1,d);

        }
        return -1;
        



    }
    private void add(int [][] grid , int dist[][] , Queue<int []> q , int nr , int nc , int d){
            int n = grid.length;
            int m = grid[0].length;

            if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 0 && dist[nr][nc] == -1){
                dist[nr][nc] = d + 1;
                q.add(new int[]{nr,nc});

            }
        }
}