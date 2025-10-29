class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums,0,list);
        return list;


    }
    private void backtrack(int nums[] , int idx , List<List<Integer>> list){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums){
                temp.add(num);
            }
            list.add(temp);
            return;
        }
        for(int i = idx ; i < nums.length ; i++){
            swap(nums,idx,i);
            backtrack(nums,idx+1,list);
            swap(nums,idx,i);
        }
    }
    private void swap(int []nums , int idx , int i ){
        int temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp;
    }
}