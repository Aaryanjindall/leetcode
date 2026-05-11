class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean vis[][] = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == 0){
                    vis[i][j] = true;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j] == true){
                    System.out.println(i+""+j);
                    for(int k = 0 ; k < m ; k++){
                        matrix[i][k] = 0;
                    }
                    for(int k = 0 ; k < n ; k++){
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
}