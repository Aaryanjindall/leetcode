class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(nums,list,0,new ArrayList<>());
        // list.add(new ArrayList<>());
        return list;
    }
    private void bt(int nums[] , List<List<Integer>> list , int cur , List<Integer> lister){
        // if(cur == nums.length){
            list.add(new ArrayList<>(lister));
            // return;
        // }
        for(int i = cur ; i < nums.length ; i++){
            lister.add(nums[i]);
            bt(nums,list,i+1,lister);
            lister.remove(lister.size()-1);
        }
    }
}