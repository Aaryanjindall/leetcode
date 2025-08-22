class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        int i = 0;
        while(j < n){
            int value = nums[j];
            while(j<n && value == nums[j]){
                j++;
            }
            nums[i++] = value;

        }
        return i;
    }
}