class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int neg = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                sum += Math.abs(matrix[i][j]);
                min = Math.min(min,Math.abs(matrix[i][j]));
                if(matrix[i][j] < 0){
                    neg++;
                }
            }
        }
        System.out.println(min);
        if(neg % 2 == 0){
            return sum;
        }
        return sum-2*min;
        
    }
}