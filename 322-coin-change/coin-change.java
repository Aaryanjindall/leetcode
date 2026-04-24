class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int [coins.length+1][amount+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int ans = solve(coins,amount,dp,coins.length-1);
        return (ans == (int)1e9)?-1:ans;
    }
    private int solve(int coins[] , int amt , int dp[][] ,int n){
        if(amt == 0){
            return 0;
        }
        if(n<0){
            return (int)1e9;
        }
        if(dp[n][amt] != -1){
            return dp[n][amt];
        } 
        int take = (int)1e9;
        if(coins[n]<=amt){
            take = 1+solve(coins,amt-coins[n],dp,n);
        }
        int skip = solve(coins,amt,dp,n-1);
        dp[n][amt] = Math.min(take,skip);
        return dp[n][amt];
    }
}