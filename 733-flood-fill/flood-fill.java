class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int oldcolor = image[sr][sc];
        if(oldcolor == color){
            return image;
        }
        boolean vis[][] = new boolean[n][m];
        dfs(image,sr,sc,color,oldcolor,vis);
        return image;
    }
    private void dfs(int[][]image , int sr , int sc , int color , int old,boolean vis[][]){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != old){
            return;
        }
        if(vis[sr][sc] == true){
            return;
        }
        image[sr][sc] = color;
        vis[sr][sc] = true;
        dfs(image,sr+1,sc,color,old,vis);
        dfs(image,sr-1,sc,color,old,vis);
        dfs(image,sr,sc+1,color,old,vis);
        dfs(image,sr,sc-1,color,old,vis);
    }
}