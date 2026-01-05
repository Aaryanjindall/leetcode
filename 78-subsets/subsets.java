class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        bt(nums,0,new ArrayList<>());
        return list;
    }
    private void bt(int nums[] , int curr , List<Integer> lister){
        
            list.add(new ArrayList<>(lister));
        
        for(int i = curr ; i < nums.length ; i++){
            lister.add(nums[i]);
            bt(nums,i+1,lister);
            lister.remove(lister.size()-1);
        }
    }
}