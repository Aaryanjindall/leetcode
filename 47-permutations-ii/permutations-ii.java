class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,nums,0);
        return list;
    }
    private void backtrack(List<List<Integer>> list , int nums[] , int curr){
        if(curr == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums){
                temp.add(num);
            }
            list.add(temp);
            return;
        }
        HashSet<Integer> hs = new HashSet<>();
       //recursion
        for(int i = curr ; i < nums.length ; i++){
            if(hs.contains(nums[i])){
                continue;
            }
            hs.add(nums[i]);
            swap(nums,i,curr);
            backtrack(list,nums,curr+1);
            swap(nums,i,curr);
        }

    }
    private void swap(int nums[] , int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}