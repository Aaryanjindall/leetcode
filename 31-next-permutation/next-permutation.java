class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = n-2 ; i >= 0 ; i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            reverse(nums,0,n-1);
            return;
        }
        int y = -1;
        for(int i = n-1 ; i >= idx ; i--){
            if(nums[i]>nums[idx]){
                y = i;
                swap(nums,i,idx);
                break;
            }
        }
        reverse(nums,idx+1,n-1);
    }
    private void swap(int nums[], int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private void reverse(int nums[] , int a , int b){
        while(a<b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }
    }
}