class Solution {
    public int minDistance(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();
        int dp[][] = new int[n+1][m+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(dp,w1,w2,0,0);
    }
    private int solve(int [][]dp , String w1 , String w2 , int i , int j){
        if(i == w1.length()){
            return w2.length()-j;
        }
        if(j == w2.length()){
            return w1.length()-i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(w1.charAt(i) == w2.charAt(j)){
            return dp[i][j] = solve(dp,w1,w2,i+1,j+1);
        }
        int insert = solve(dp,w1,w2,i,j+1);
        int delete = solve(dp,w1,w2,i+1,j+1);
        int replace = solve(dp,w1,w2,i+1,j);
        return dp[i][j] = 1+Math.min(insert,Math.min(delete,replace));
    }
}