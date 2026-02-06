class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 0;
        int j = 0;
        int pr = 1;
        for(int i = 0 ; i < nums.length ; i++){
            pr *= nums[i];
            while(pr >= k){
                pr /= nums[j];
                j++;
            }
            count += i-j+1;
        }
        return count;
    }
}