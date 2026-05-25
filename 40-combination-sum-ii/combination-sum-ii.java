class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int tar) {
        Arrays.sort(cand);
        List<List<Integer>> list = new ArrayList<>();
        bt(list,cand,tar,0,new ArrayList<>());
        return list;
    }
    private void bt(List<List<Integer>> list , int cand[] , int tar , int curr , List<Integer> lister){
        if(tar == 0){
            list.add(new ArrayList<>(lister));
            return;
        }
        if(tar <0){
            return;
        }
        for(int i = curr ; i < cand.length ; i++){
            if(i>curr && cand[i] == cand[i-1])continue;
            lister.add(cand[i]);
            bt(list,cand,tar-cand[i],i+1,lister);
            lister.remove(lister.size()-1);
        }
    }
}