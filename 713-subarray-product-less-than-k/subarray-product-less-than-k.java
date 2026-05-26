class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int sub = 0;
        int j = 0;
        int n = nums.length;
        int pr = 1;
        for(int i = 0 ; i < n ; i++){
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