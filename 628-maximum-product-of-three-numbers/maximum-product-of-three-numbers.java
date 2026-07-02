class Solution {
    public int maximumProduct(int[] nums){
        int pr = 1;
        int n = nums.length;
        Arrays.sort(nums);
        int max1 = nums[n-1];
        int max2 = nums[n-2];
        int max3 = nums[n-3];
        int min1 = nums[0];
        int min2 = nums[1];
        int neg = 0;
        pr = Math.max((max1*max2*max3),(max1*min1*min2));
        return pr;
    }
}