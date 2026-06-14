class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(list,nums,0,new ArrayList<>());
        return list;
    }
    private void bt(List<List<Integer>> list ,int nums[], int curr , List<Integer> lister){
        list.add(new ArrayList<>(lister));
        for(int i = curr ; i < nums.length ; i++){
            lister.add(nums[i]);
            bt(list,nums,i+1,lister);
            lister.remove(lister.size()-1);
        }
    }
}