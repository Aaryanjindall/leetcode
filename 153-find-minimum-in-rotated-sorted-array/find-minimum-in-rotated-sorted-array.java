class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length -1;
        int ans = Integer.MAX_VALUE;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(nums[mid] > nums[e]){
                ans = Math.min(nums[mid],ans);  
                s = mid+1;
            }
            else{
                ans = Math.min(nums[mid],ans);
                e = mid-1;
            }
            
        }
        return ans;
    }
}