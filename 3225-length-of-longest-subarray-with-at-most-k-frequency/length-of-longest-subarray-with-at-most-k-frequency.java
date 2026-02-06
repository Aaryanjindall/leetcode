class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        int j = 0;
        int len = 0;
        int maxlen = 0;
        for(int i = 0 ; i < n ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            
            while(hm.get(nums[i])>k){
                hm.put(nums[j],hm.get(nums[j])-1);
                if(hm.get(nums[j]) == 0){
                    hm.remove(nums[j]);
                }
                j++;
            }
            len = i-j+1;
            maxlen = Math.max(len,maxlen);
        }
        return maxlen;
    }
}