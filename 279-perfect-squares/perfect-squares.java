class Solution {
    public int numSquares(int n) {
        int dp[] = new int [n+1];
        Arrays.fill(dp,-1);
        return solve(dp,n);
    }
    private int solve(int dp[], int n){
        if(n == 0){
            return dp[n] = 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i *i <= n ; i++){
            min = Math.min(min,1+solve(dp,n-i*i));
        }
        dp[n] = min;
        return dp[n];
    }

}