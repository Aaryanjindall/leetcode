class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[nums.length];
        int s = 0;
        int ss = n;
        int idx = 0;
        for(int i = 0 ; i < n ; i++){
            ans[idx++] = nums[i];
            ans[idx++] = nums[i+ss];
        }
        return ans;
    }
}