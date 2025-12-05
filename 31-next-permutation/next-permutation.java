class Solution {
    
    static void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        // Step 1: Find breakpoint
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                idx = i;
                break;
            }
        }

        // If no breakpoint found, just reverse whole array
        if(idx == -1){
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find next greater element (rightmost greater)
        int j = -1;
        for(int i = n - 1; i > idx; i--){
            if(nums[i] > nums[idx]){
                j = i;
                break;
            }
        }

        // Step 3: Swap idx and j
        int temp = nums[idx];
        nums[idx] = nums[j];
        nums[j] = temp;

        // Step 4: Reverse the right part
        reverse(nums, idx + 1, n - 1);
    }
}
