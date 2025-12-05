class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int leftsum = 0;
        int rightsum = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return 0;
        }
        return n-1;
        
    }
}