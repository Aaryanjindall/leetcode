class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int curr = 1;
        int max = 1;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] > nums[i-1]){
                curr++;
                max = Math.max(max,curr);
            }
            else{
                curr = 1;
            }
        }
        return max;
    }
}