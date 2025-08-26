class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int l = 0;
        int h = mat[0].length -1;
        while(l <= h){
            int mid = l + (h-l)/2;
            int idx = max(mat,mid,row,col);
            int left = (mid-1 >= 0 )? mat[idx][mid-1] : -1;
            int right = (mid+1 < col )? mat[idx][mid+1] : -1;
            if(mat[idx][mid] > left && mat[idx][mid] > right){
                return new int[]{idx,mid};
            }
            else if(mat[idx][mid] < left){
                h = mid -1;
            }
            else{
                l = mid + 1;
            }



        }
        return new int[]{-1,-1};
    }
    private int max(int [][] mat , int mid , int row , int col){
        int index = -1;
        int max = 0;

        for(int i = 0 ; i < row ; i++ ){
            if(mat[i][mid] > max){
                max = mat[i][mid];
                index = i;
            }
        }
        return index;
        
    }
}