class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int ans[] = new int[2];
        int index= 0;
        for(int i : hm.keySet()){
            if(hm.get(i) == 2){
                ans[index++] = i;
            }
        }
        return ans;
    }
}