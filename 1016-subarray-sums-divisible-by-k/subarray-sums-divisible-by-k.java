class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        int count = 0;
        int prefix = 0;
        hm.put(0,1);
        for(int i = 0 ; i < n ; i++){
            prefix += nums[i];
            int mod = ((prefix%k)+k)%k;
            if(hm.containsKey(mod)){
                count += hm.get(mod);
            }
            
            hm.put(mod,hm.getOrDefault(mod,0)+1);
        }
        return count;
    }
}