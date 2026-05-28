class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int sub = 0;
        int prefix = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i = 0 ; i < n ; i++){
            prefix += nums[i];
            int mod = ((prefix%k)+k)%k;
            if(hm.containsKey(mod)){
                sub += hm.get(mod);
            }
            hm.put(mod,hm.getOrDefault(mod,0)+1);
        }
        return sub;
    }
}