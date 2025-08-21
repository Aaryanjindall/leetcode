class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length -1;
        int ans = -1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(nums[mid] == target){
                ans = mid;
            }
            
            if (nums[l] <= nums[mid]) {
                // If target is within the sorted left half
                if (target >= nums[l] && target < nums[mid]) {
                    h = mid - 1;
                } else {
                    // Target is in the unsorted right half
                    l = mid + 1;
                }
            }
            // Otherwise, the right half must be sorted
            else {
                // If target is within the sorted right half
                if (target > nums[mid] && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    // Target is in the unsorted left half
                    h = mid - 1;
                }
            }

        }
        return ans;
    }
}