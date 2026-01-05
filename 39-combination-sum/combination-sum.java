class Solution {
    List<List<Integer>> lister = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] cand, int tar) {
        bt(cand,tar,new ArrayList<>(),0);
        return lister;
    }
    private void bt(int cand[] , int tar , List<Integer> list , int curr){
        if(tar == 0){
            lister.add(new ArrayList<>(list));
            return;
        }
        if (tar < 0) return; 
        
        for(int i = curr ; i < cand.length ; i++){
            list.add(cand[i]);
            bt(cand,tar-cand[i],list,i);
            list.remove(list.size()-1);

        }
    }
}