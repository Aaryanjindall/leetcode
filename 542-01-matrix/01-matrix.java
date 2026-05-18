class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
                else{
                    ans[i][j] = -1;
                }
            }
        }
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int k = 0 ; k < 4 ; k++){
                int nr = r+dx[k];
                int nc = c+dy[k];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && ans[nr][nc] == -1){
                    ans[nr][nc] = 1 + ans[r][c];
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return ans;
    }

}