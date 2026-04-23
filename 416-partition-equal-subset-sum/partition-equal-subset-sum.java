class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum % 2 != 0){
            return false;
        }
        int tar = sum/2;
        int dp[][] = new int[nums.length][tar+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(dp,tar,0,nums);
    }
    private boolean solve(int dp[][] , int tar , int cur , int nums[]){
        if(tar == 0){
            return true;
        }
        if(cur == nums.length){
            return false;
        }
        if(dp[cur][tar] != -1){
            return dp[cur][tar] == 1;
        }
        boolean take = false;
        if(nums[cur] <= tar){
            take = solve(dp,tar-nums[cur],cur+1,nums);
        }
        boolean skip = solve(dp,tar,cur+1,nums);
        dp[cur][tar] = (take || skip)?1:0;
        return (take || skip);
    }
}