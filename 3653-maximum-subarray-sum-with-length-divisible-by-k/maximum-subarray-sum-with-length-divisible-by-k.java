class Solution {
    public long maxSubarraySum(int[] nums, int k){
        HashMap<Integer,Long> hm = new HashMap<>();
        long prefix = 0;
        long ans = Long.MIN_VALUE;
        hm.put(0,0L);
        for(int i = 0 ; i < nums.length ; i++){
            int mod = (i+1)%k;
            prefix += nums[i];
            if(hm.containsKey(mod)){
                ans = Math.max(ans,prefix-hm.get(mod));
                hm.put(mod,Math.min(hm.get(mod),prefix));
            }
            else{
                hm.put(mod,prefix);
            }
        }
        return ans;
    }
}