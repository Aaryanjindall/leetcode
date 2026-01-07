class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstf(nums,target);
        int last = lastl(nums,target);
        return new int[]{first,last};

    }
    private int firstf(int nums[] , int tar){
        int l = 0;
        int h = nums.length-1;
        int ans = -1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(nums[mid] == tar){
                ans = mid;
                h = mid-1;
            }
            else if(nums[mid]<tar){
                l = mid+1;
            }
            else{
                h = mid-1;
            }

        }
        return ans;
    }
    private int lastl(int nums[] , int tar){
        int l = 0;
        int h = nums.length-1;
        int ans = -1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(nums[mid] == tar){
                ans = mid;
                l = mid+1;
            }
            else if(nums[mid]<tar){
                l = mid+1;
            }
            else{
                h = mid-1;
            }

        }
        return ans;
    }
}