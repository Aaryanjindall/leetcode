class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int diff[] = new int[nums.length];
        for(int req[] : requests){
            int a = req[0];
            int b = req[1];
            diff[a] += 1;
            if(b+1 < nums.length){
                diff[b+1] -= 1;
            }
            
        }
        for(int i = 1 ; i < diff.length ; i++){
            diff[i] += diff[i-1];
        }
        Arrays.sort(nums);
        Arrays.sort(diff);
        long ans = 0;
        int mod = 1000000007;
        for(int i = nums.length-1 ; i >= 0 ; i--){
            ans = (ans + (long) nums[i] * diff[i]) % mod;
        }
        return (int)ans;
    }
}