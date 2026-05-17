class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int [coins.length][amount+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int ans = solve(dp,coins.length-1,coins,amount);
        return ans;
    }
    private int solve(int dp[][] , int i , int coins[] , int amount){
        if(amount == 0){
            return 1;
        }
        if(amount < 0){
            return 0;
        }
        if(i < 0){
            return 0;
        }
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }
        int take = 0;
        if(coins[i]<=amount){
            take = solve(dp,i,coins,amount-coins[i]);
        }
        int skip = solve(dp,i-1,coins,amount);
        return dp[i][amount] = take+skip;
    }
}