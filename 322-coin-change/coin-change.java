class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int dp[][] = new int[coins.length+1][amount+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int ans = solve(coins,amount,n-1,dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int solve(int coins[] , int amount , int i , int [][]dp){
        if (amount == 0) return 0;
        if (i < 0) return Integer.MAX_VALUE;
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }
        int take = Integer.MAX_VALUE;
        if(amount >= coins[i]){
            int res = solve(coins, amount - coins[i], i, dp);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }
        int skip = solve(coins,amount,i-1,dp);
        return dp[i][amount] = Math.min(take,skip);
    }

}