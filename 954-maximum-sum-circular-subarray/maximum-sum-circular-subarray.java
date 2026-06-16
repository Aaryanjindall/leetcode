class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxcurr = nums[0];
        int max = nums[0];
        int mincurr = nums[0];
        int min = nums[0];
        int total = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            maxcurr = Math.max(nums[i],maxcurr+nums[i]);
            max = Math.max(maxcurr,max);
            mincurr = Math.min(nums[i],mincurr+nums[i]);
            min = Math.min(mincurr,min);
            total += nums[i];
        }
        if(max
         < 0){
            return max;
        }
        return Math.max(max,total-min);
    }
}