class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int length = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            while(sum >= target){
                length = i-j+1; 
                min = Math.min(min,length);
                sum -= nums[j];
                j++;
            }
        }
        return (min == Integer.MAX_VALUE)?0:min;
    }
}