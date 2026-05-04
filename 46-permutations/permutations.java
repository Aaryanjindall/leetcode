class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(nums,list,0);
        return list;
    }
    private void bt(int nums[], List<List<Integer>> list, int curr){
        if(curr == nums.length){
            List<Integer> lister = new ArrayList<>();
            for(int n : nums){
                lister.add(n);
            }
            list.add(lister);
            return;
        }
        for(int i = curr ; i < nums.length ; i++){
            swap(nums,i,curr);
            bt(nums,list,curr+1);
            swap(nums,i,curr);
        }
    }
    private void swap(int nums[] , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}