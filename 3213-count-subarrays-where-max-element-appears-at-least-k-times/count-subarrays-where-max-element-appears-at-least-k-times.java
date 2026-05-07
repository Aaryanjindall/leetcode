class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long total = (long) n * (n + 1) / 2;
        int max = 0;
        for(int i : nums){
            max = Math.max(i,max);
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        long atmost = 0;
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            while(hm.getOrDefault(max, 0) >= k){
                hm.put(nums[j],hm.get(nums[j])-1);
                if(hm.get(nums[j]) == 0){
                    hm.remove(nums[j]);
                }
                j++;
            }
            atmost += i-j+1;
        }

        return total - atmost;

    }
}