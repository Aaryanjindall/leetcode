class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int [] fin = new int [nums.length];
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        left[0] = 0;
        right[n-1] = 0;
        
        for(int i = 1 ; i < nums.length ; i++ ){
            left[i] = nums[i-1]+left[i-1];
        }
        for(int i = n-2 ; i >= 0 ; i--){
            right[i] = nums[i+1]+right[i+1];
        }
        for(int i = 0 ; i < n ; i++){
            fin[i] = Math.abs(left[i]-right[i]);
        }
        return fin;
    }
}