class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans = solve(nums,k) - solve(nums,k-1);
        return ans;
    }
    private int solve(int nums[] , int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int j = 0;
        int len = 0;
        int sub = 0;
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