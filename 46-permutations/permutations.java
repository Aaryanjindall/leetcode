class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(list,nums,0);
        return list;
    }
    private void bt(List<List<Integer>> list , int nums[] , int cur ){
        if(cur == nums.length){
            List<Integer> lister = new ArrayList<>();
            for(int x : nums){
                lister.add(x);
            }
            list.add(lister);
            return;
        }
        for(int i = cur ; i < nums.length ; i++){
            swap(nums,i,cur);
            bt(list,nums,cur+1);
            swap(nums,i,cur);
        }
    }
    private void swap(int nums[] , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}