class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int tar) {
        List<List<Integer>> list = new ArrayList<>();
        bt(list,cand,tar,new ArrayList<>(),0);
        return list;
    }
    private void bt(List<List<Integer>> list , int [] cand , int tar , List<Integer> lister,int cur){
        if(tar == 0){
            list.add(new ArrayList<>(lister));
            return;
        }
        if(tar < 0){
            return;
        }
        for(int i = cur ; i < cand.length ; i++){
            lister.add(cand[i]);
            bt(list,cand,tar-cand[i],lister,i);
            lister.remove(lister.size()-1);
        }
    }
}