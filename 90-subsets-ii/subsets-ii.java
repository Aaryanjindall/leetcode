class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        bt(list,0,nums,new ArrayList<>(),hs);
        return list;
    }
    private void bt(List<List<Integer>> list, int curr , int nums[] , List<Integer> lister,HashSet<List<Integer>> hs){
        if(!hs.contains(lister)){
            hs.add(new ArrayList<>(lister));
            list.add(new ArrayList<>(lister));
        }
        for(int i = curr ; i < nums.length ; i++){
            lister.add(nums[i]);
            bt(list,i+1,nums,lister,hs);
            lister.remove(lister.size()-1);
        }
    }
}