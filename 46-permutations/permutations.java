class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(list,nums,0);
        return list;
    }
    private void bt(List<List<Integer>> list, int nums[] , int curr){
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
            bt(list,nums,curr+1);
            swap(nums,i,curr);
        }
    }
    private void swap(int nums [], int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}