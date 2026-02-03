class Solution {
    public int minimumCost(int[] nums) {
        int b = 51;
        int c = 51;
        // int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] < b){
                c = b;
                b = nums[i];
            }
            else if(nums[i] < c  ){
                c = nums[i];
            }
            
        }
        return nums[0]+b+c;
    }
}