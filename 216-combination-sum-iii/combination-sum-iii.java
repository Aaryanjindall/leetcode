class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,1,k,n,new ArrayList<>());
        return list;
    }
    private void backtrack(List<List<Integer>> list , int curr , int k , int tar , List<Integer> ans){
        if(k == 0){
            if(tar == 0){
                list.add(new ArrayList<>(ans));
            }
        }
        for(int i = curr ; i <=9  ; i++){
            ans.add(i);
            backtrack(list,i+1,k-1,tar-i,ans);
            ans.remove(ans.size()-1);
        }
    }
}