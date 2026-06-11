class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    private int atmost(int nums[] , int k){
        int odd = 0;
        int j = 0;
        int sub = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] % 2 == 1){
                odd++;
            }
            while(odd > k){
                if(nums[j] %2 == 1){
                    odd--;
                }
                j++;
            }
            sub += i-j+1;
        }
        return sub;
    }
}