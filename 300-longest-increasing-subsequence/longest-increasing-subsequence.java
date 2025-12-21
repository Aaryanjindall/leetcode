class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,dp,0,-1);
    }
    private int solve(int nums[] , int dp[][] , int curr , int par){
        if(curr >= nums.length){
            return 0;
        }
        if(dp[curr][par+1] != -1){
            return dp[curr][par+1];
        }
        int take = 0;
        if(par == -1 || nums[curr] > nums[par]){
            take = 1+solve(nums,dp,curr+1,curr);
        }
        int skip = solve(nums,dp,curr+1,par);
        return dp[curr][par+1] = Math.max(take,skip);
    }
}