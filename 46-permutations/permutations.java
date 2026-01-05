class Solution {
    List<List<Integer>> lister = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        bt(nums,0);
        return lister;
    }
    private void bt(int nums[] , int curr ){
        if(curr == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            lister.add(list);
        }
        for(int i = curr ; i < nums.length ; i++){
            swap(nums,i,curr);
            bt(nums,curr+1);
            swap(nums,i,curr);

        }
    }
    private void swap(int nums[] , int i , int curr){
        int temp = nums[i];
        nums[i] = nums[curr];
        nums[curr] = temp;
    }
}