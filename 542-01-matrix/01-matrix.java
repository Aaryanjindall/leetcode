class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int [][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];
        int dist[][] = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j,0});
                    // dist[i][j] = 0;
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int top[] = q.poll();
            int i = top[0];
            int j = top[1];
            int d = top[2];
            dist[i][j] = d;
            helper(mat,i+1,j,vis,dist,d,q);
            helper(mat,i,j+1,vis,dist,d,q);
            helper(mat,i-1,j,vis,dist,d,q);
            helper(mat,i,j-1,vis,dist,d,q);

            

        }
        return dist;
        


    }
    private void helper(int mat[][] , int i , int j , boolean vis[][] , int dist[][] , int d , Queue<int[]> q){
            int n = mat.length;
            int m = mat[0].length;

            if(i >= 0 && i < n && j >= 0 && j < m && !vis[i][j]){
                dist[i][j] = d +1;
                q.add(new int[]{i,j,d+1});
                vis[i][j] = true;
            }
        }
}