class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        bt(nums,list,0,new ArrayList<>());
        return new ArrayList<>(list);
    }
    private void bt(int nums[] , Set<List<Integer>> list , int curr , List<Integer> lister){
        list.add(new ArrayList<>(lister));
        for(int i = curr ; i < nums.length ; i++){
            lister.add(nums[i]);
            bt(nums,list,i+1,lister);
            lister.remove(lister.size()-1);
        }
    }
} 