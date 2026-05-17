class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxcurr = nums[0];
        int mincurr = nums[0];
        int total = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            maxcurr = Math.max(nums[i],nums[i]+maxcurr);
            max = Math.max(max,maxcurr);
            mincurr = Math.min(nums[i],nums[i]+mincurr);
            min = Math.min(min,mincurr);
            total += nums[i];
        }
        if(max < 0){
            return max;
        }
        return Math.max(max,total-min);
    }
}