class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(dp,0,-1,nums);
    }
    private int solve(int dp[][] , int curr , int par , int nums[]){
        if(curr == nums.length){
            return 0;
        }
        if(dp[curr][par+1] != -1){
            return dp[curr][par+1];
        }
        int take = 0;
        if(par == -1 || nums[curr]>nums[par]){
            take = 1+solve(dp,curr+1,curr,nums);
        }
        int skip = solve(dp,curr+1,par,nums);
        return dp[curr][par+1] = Math.max(take,skip);
    }
}