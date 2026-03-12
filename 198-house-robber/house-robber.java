class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(nums,dp,0);
    }
    private int solve(int nums[] , int dp[] , int curr){
        if(curr >= nums.length){
            return 0;
        }
        if(dp[curr] != -1){
            return dp[curr];
        }
        int take = nums[curr]+solve(nums,dp,curr+2);
        int skip = solve(nums,dp,curr+1);
        return dp[curr] = Math.max(take,skip);
    }
}