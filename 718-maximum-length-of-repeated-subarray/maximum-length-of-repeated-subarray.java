class Solution {
    public int findLength(int[] n1, int[] n2) {
        int n = n1.length;
        int m = n2.length;
        int dp[][] = new int[n+1][m+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                ans = Math.max(ans,solve(dp,i,j,n,m,n1,n2));
            }
        }
        return ans;
    }
    private int solve(int dp[][] , int i , int j , int n , int m, int []n1 , int[]n2){
        if(i == n || j == m){
            return dp[i][j] = 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(n1[i] == n2[j]){
            return dp[i][j] = 1 + solve(dp,i+1,j+1,n,m,n1,n2);
        }
        return dp[i][j] = 0;
    }

}