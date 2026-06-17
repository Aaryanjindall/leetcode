class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(nums,0,-1,dp);
    }
    private int solve(int nums[] , int cur , int par , int dp[][]){
        if(cur == nums.length){
            return 0;
        }
        if(dp[cur][par+1] != -1){
            return dp[cur][par+1];
        }
        int take = 0;
        if(par == -1 || nums[cur] > nums[par]){
            take = 1+solve(nums,cur+1,cur,dp);
        }
        int skip = solve(nums,cur+1,par,dp);
        return dp[cur][par+1] = Math.max(take,skip);
    }
}