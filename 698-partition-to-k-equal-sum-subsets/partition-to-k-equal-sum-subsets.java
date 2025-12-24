class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0){
            return false;
        }
        int tar = sum/k;

        Arrays.sort(nums);
        boolean vis[] = new boolean[nums.length + 1];
        return bt(nums,tar,0,vis,0,k);
            
    }
    private boolean bt(int nums[] , int tar , int curr, boolean vis[] , int currsum , int k){
        if(k == 1)return true;
        if(curr == nums.length){
            return false;
        }
        if(currsum == tar){
            return bt(nums,tar,0,vis,0,k-1);
        }
        for(int i = curr ; i < nums.length ; i++){
            if(vis[i] || nums[i] + currsum > tar){
                continue;
            }
            vis[i] = true;
            if(bt(nums,tar,i+1,vis,currsum+nums[i],k)){
                return true;
            }
            vis[i] = false;
        }
        return false;
    }
}