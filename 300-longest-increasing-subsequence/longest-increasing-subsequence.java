class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int [nums.length+1][nums.length+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(nums,dp,0,-1);
    }
    private int solve(int nums[] , int dp[][] , int cur,int par){
        if(cur >= nums.length){
            return 0;
        }
        if(dp[cur][par+1] != -1){
            return dp[cur][par+1];
        }
        int take = 0;
        if(par == -1 || nums[par] < nums[cur]){
            take = 1+solve(nums,dp,cur+1,cur);
        }
        int skip = solve(nums,dp,cur+1,par);
        return dp[cur][par+1] = Math.max(take,skip);
    }
}