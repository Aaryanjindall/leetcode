class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        //exactly k nikalne ke liye atmost(k) - atmost(k-1) krna pdega 
        return atmost(nums,k)-atmost(nums,k-1);
    }
    private int atmost(int nums[] , int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int j = 0;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            while(hm.size()>k){
                hm.put(nums[j],hm.get(nums[j])-1);
                if(hm.get(nums[j]) == 0){
                    hm.remove(nums[j]);
                }
                j++;
            }
            count += i-j+1;
        }
        return count;

    }

}