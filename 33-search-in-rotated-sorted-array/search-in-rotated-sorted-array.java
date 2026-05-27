class Solution {
    public int search(int[] nums, int tar) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int ans = -1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid] == tar){
                return mid;
            }
            else if(nums[l] <= nums[mid]){
                if(tar >= nums[l] && tar < nums[mid]){
                    h = mid-1;
                }        
                else{
                    l = mid+1;
                }
            }
            else{
                if(tar > nums[mid] && tar <= nums[h]){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
        }
        return ans;
    }
}