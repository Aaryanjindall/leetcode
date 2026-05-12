class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int exact = atmost(nums,k)-atmost(nums,k-1);
        return exact;
    }
    private int atmost(int nums[],int k){
        int n = nums.length;
        int count = 0;
        int oddcount = 0;
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]%2 == 1){
                oddcount++;
            }
            while(oddcount>k){
                if(nums[j]%2 == 1){
                    oddcount--;
                }
                j++;
            }
            count += (i-j+1);
        }
        return count;
    }
}