class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum % 2 == 1){
            return false;
        }
        int tar = sum/2;
        int dp[][] = new int[n+1][tar+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(dp,nums,tar,0);
    }
    private boolean solve(int dp[][] , int nums[] , int tar , int cur){
        if(tar == 0){
            return true;
        }
        if(tar < 0){
            return false;
        }
        if(cur >= nums.length){
            return false;
        }
        if(dp[cur][tar] != -1){
            return dp[cur][tar] == 1;
        }
        boolean take = false;
        if(nums[cur] <= tar){
            take = solve(dp,nums,tar-nums[cur],cur+1);
        }
        boolean skip = solve(dp,nums,tar,cur+1);
        dp[cur][tar] = (take || skip)?1:0;
        return take||skip;
    }
}