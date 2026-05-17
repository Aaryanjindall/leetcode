class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int n = coins.length;
        int ans = solve(dp,n-1,coins,amount);
        return (ans == (int)1e9)?-1:ans;
    }
    private int solve(int dp[][] , int i , int []coins , int amount){
        if(i < 0){
            return (int)1e9;
        }
        if(amount == 0){
            return dp[i][amount] = 0;
        }
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }
        int take = (int)1e9;
        if(coins[i]<=amount){
            take = 1+solve(dp,i,coins,amount-coins[i]);
        }
        int skip = solve(dp,i-1,coins,amount);
        return dp[i][amount] = Math.min(take,skip);
    }
}