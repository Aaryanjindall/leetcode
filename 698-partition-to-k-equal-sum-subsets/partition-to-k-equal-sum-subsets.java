class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum % k != 0){
            return false;
        }
        int tar = sum/k;
        boolean vis[] = new boolean[nums.length+1];
        return solve(nums,k,tar,vis,0,tar);
    }
    private boolean solve(int nums[] , int k , int tar , boolean vis[] , int cur,int target){
        if(k == 0){
            return true;
        }
        if(tar == 0){
            return solve(nums,k-1,target,vis,0,target);
        }
        if(cur >= nums.length || tar < 0){
            return false;
        }
        for(int i = cur ; i < nums.length ; i++){
            if(vis[i]){
                continue;
            }
            vis[i] = true;
            if(solve(nums,k,tar-nums[i],vis,i+1,target)){
                return true;
            }
            vis[i] = false;
        }
        return false;
    }
}