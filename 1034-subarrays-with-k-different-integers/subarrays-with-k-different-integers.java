class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }
    private int atmost(int nums[] , int k){
        int sub = 0;
        int j = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            while(hm.size()>k){
                hm.put(nums[j],hm.get(nums[j])-1);
                if(hm.get(nums[j]) == 0){
                    hm.remove(nums[j]);
                }
                j++;
            }
            sub += i-j+1;
        }
        return sub;
    }
}