class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int n = nums.length;
        int prefix = 0;
        for(int i = 0 ; i < n ; i++){
            prefix += nums[i];
            int mod = (prefix)%k;
            if(hm.containsKey(mod)){
                int prev = hm.get(mod);
                if(i-prev >= 2){
                    return true;
                }
                
            }
            else{
                    hm.put(mod,i);
                }
        }
        return false;
    }
}