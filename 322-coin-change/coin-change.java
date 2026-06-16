class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int ans = solve(dp,coins,amount,n-1);
        return (ans == (int)1e9) ? -1 : ans;
    }
    private int solve(int dp[][] , int c[] , int am , int cur){
        if(cur < 0){
            return (int)1e9;
        }
        if(am == 0){
            return 0;
        }
        if(dp[cur][am] != -1){
            return dp[cur][am];
        }
        int take = (int)1e9;
        if(c[cur] <= am){
            take = 1+solve(dp,c,am-c[cur],cur);
        }
        int skip = solve(dp,c,am,cur-1);
        return dp[cur][am] = Math.min(take,skip);
    }
}