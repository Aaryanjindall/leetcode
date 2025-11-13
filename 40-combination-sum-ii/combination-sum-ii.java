class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list,candidates,target,0,new ArrayList<>());
        return list;
    }
    private void backtrack(List<List<Integer>> list , int [] candidates , int tar , int curr , List<Integer> ans){
        if(tar == 0){
            list.add(new ArrayList<>(ans));
            return;
        }
        if(tar<0 || curr == candidates.length){
            return;
        }
        for(int i = curr ; i < candidates.length ; i++){
            if(i > curr && candidates[i]== candidates[i-1]){
                continue;
            }
            ans.add(candidates[i]);
            backtrack(list,candidates,tar-candidates[i],i+1,ans);
            ans.remove(ans.size()-1);
        }
    }
}