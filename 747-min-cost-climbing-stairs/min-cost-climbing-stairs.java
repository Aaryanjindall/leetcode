class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(find(cost,dp,0),find(cost,dp,1));

    }
    private int find(int cost[] , int dp[] , int curr){
        if(curr >= cost.length){
            return 0;
        }
        if(dp[curr] != -1){
            return dp[curr];
        }
        int take = cost[curr] + find(cost,dp,curr+1);
        int take2 = cost[curr] + find(cost,dp,curr+2);
        dp[curr] = Math.min(take,take2);
        return dp[curr];
    }
}