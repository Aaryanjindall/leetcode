class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int sr = 0;
        int sc = 0;
        int er = n-1;
        int ec = m-1;
        while(sr <= er && sc <= ec){
            for(int i = sr ; i <= ec;i++){
                list.add(matrix[sr][i]);
            }
            for(int i = sr+1 ; i <= er;i++){
                list.add(matrix[i][ec]);
            }
            for(int i = ec-1 ; i >= sc ;i--){
                if(sr == er){
                    break;
                }
                list.add(matrix[er][i]);
            }
            for(int i = er-1 ; i >= sr+1 ;i--){
                if(sc == ec){
                    break;
                }
                list.add(matrix[i][sc]);
            }
            sr++;
            er--;
            sc++;
            ec--;
        }
        return list;
    }
}