class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int pr = 1;
        int j = 0;
        int sub = 0;
        for(int i = 0 ; i < nums.length ; i++){
            pr *= nums[i];
            while(pr >= k){
                pr = (pr/nums[j]);
                j++;
            }
            sub += i-j+1;
        }
        return sub;
    }
}