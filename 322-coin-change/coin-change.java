class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int dp[][] = new int[coins.length+1][amount+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int ans = solve(coins,amount,dp,n-1);
        return (ans == (int)1e9)?-1 : ans;
    }
    private int solve(int coins[] , int amount , int dp[][] , int curr){
        if(curr < 0){
            return (int)1e9;
        }
        if(amount == 0){
            return 0;
        }
        if(dp[curr][amount] != -1){
            return dp[curr][amount];
        }
        int take = (int)1e9;
        if(coins[curr]<=amount){
            take = 1+solve(coins,amount-coins[curr],dp,curr);
        }
        int skip = solve(coins,amount,dp,curr-1);
        dp[curr][amount] = Math.min(take,skip);
        return dp[curr][amount];
    }
}