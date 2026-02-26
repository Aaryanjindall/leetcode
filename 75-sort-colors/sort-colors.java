class Solution {
    public void sortColors(int[] nums){
        int l = 0;
        int m = 0;
        int h = nums.length-1;
        while(m<=h){
            if(nums[m] == 0){
                swap(nums,l,m);
                m++;
                l++;
            }
            else if(nums[m] == 2){
                swap(nums,h,m);
                // m++;
                h--;
            }
            else{
                m++;
            }
        }
    }
    private void swap(int nums[], int s , int e){
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
}