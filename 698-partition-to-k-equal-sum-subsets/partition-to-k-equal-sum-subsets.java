class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k){
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum%k != 0){
            return false;
        }
        int tar = sum/k;
        boolean vis[] = new boolean[nums.length + 1];
        return solve(nums,vis,k,tar,0,0);
    }
    private boolean solve(int nums[] , boolean vis[] , int k , int tar , int cur,int cursum){
        if(k == 0){
            return true;
        }
        if(cursum == tar){
            return solve(nums,vis,k-1,tar,0,0);
        }
        for(int i = cur ; i < nums.length ; i++){
            if(vis[i] || cursum + nums[i] > tar){
                continue;
            }
            vis[i] = true;
            if(solve(nums,vis,k,tar,i+1,cursum+nums[i])){
                return true;
            }
            vis[i] = false;
        }
        return false;
    }
}