class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int y = -1;
        for(int i = n-2 ; i >= 0 ; i--){
            if(nums[i]<nums[i+1]){
                y = i;
                break;
            }
        }
        System.out.println(y);
        if(y == -1){
            reverse(nums,0,n-1);
            return;
        }
        int idx = -1;
        for(int i = n-1 ; i >= y ; i--){
            if(nums[i]>nums[y]){
                swap(nums,i,y);
                break;
            }
        }
        reverse(nums,y+1,n-1);
    }
    private void swap(int nums[] , int x , int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    private void reverse(int nums[] , int x , int y){
        while(x<y){
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
            x++;
            y--;
        }
    }
}