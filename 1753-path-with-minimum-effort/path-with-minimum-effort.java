class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int dist[][] = new int[n][m];
        for(int row[] : dist){
            Arrays.fill(row,(int)1e9);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        pq.add(new int []{0,0,0});
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int effort = curr[0];
 
            int r = curr[1];
            int c = curr[2];

            if(r == n-1 && c == m-1)return effort;

            solve(heights,pq,dist,r+1,c,effort,r,c);
            solve(heights,pq,dist,r,c+1,effort,r,c);
            solve(heights,pq,dist,r-1,c,effort,r,c);
            solve(heights,pq,dist,r,c-1,effort,r,c);

            
            
        }
        return dist[n-1][m-1];


    }
    private void solve(int heights[][] , PriorityQueue<int[]> pq, int [][] dist , int nr , int nc,int effort , int r , int c){
        int n = heights.length;
        int m = heights[0].length;

        if(nr >= 0 && nr < n && nc >= 0 && nc < m ){
            int nexteffort = Math.max(effort,Math.abs(heights[nr][nc]-heights[r][c]));
            if(nexteffort < dist[nr][nc]){
                dist[nr][nc] = nexteffort;
                pq.add(new int[]{nexteffort,nr,nc});
            }
            
        }
    }
}