class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[][] = new int[coins.length][amount+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int ans = solve(dp,coins,amount,coins.length-1);
        return (ans == (int)1e9)? -1 : ans;
    }
    private int solve(int dp[][] , int []coins , int amount , int curr){
        if(amount == 0){
            return 0;
        }
        if(curr < 0) return (int)1e9;
        if(dp[curr][amount] != -1){
            return dp[curr][amount];
        }
        int take = (int)1e9;
        if(coins[curr]<=amount){
            take = 1+solve(dp,coins,amount-coins[curr],curr);
        }
        int skip = solve(dp,coins,amount,curr-1);
        return dp[curr][amount] = Math.min(skip,take);
    }
}