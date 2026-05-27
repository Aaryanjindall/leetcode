class Solution {
    public int searchInsert(int[] nums, int tar) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int ans = -1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]>=tar){
                ans = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}