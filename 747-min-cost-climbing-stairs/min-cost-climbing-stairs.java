class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost,0,dp),solve(cost,1,dp));
    }
    private int solve(int cost[] , int st , int dp[]){
        if(st >= cost.length){
            return 0;
        }
        if(dp[st] != -1){
            return dp[st];
        }
        int take = cost[st]+solve(cost,st+1,dp);
        int skip = cost[st]+solve(cost,st+2,dp);
        return dp[st]=Math.min(take,skip);
    }
}