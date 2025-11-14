class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int [cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(dp,cost,0),solve(dp,cost,1));
    }
    private int solve(int dp[] , int cost[] , int i){
        if(i >= cost.length){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }

        int left = solve(dp,cost,i+1);
        int right = solve(dp,cost,i+2);

        return dp[i] = cost[i] + Math.min(left,right);

    }
}