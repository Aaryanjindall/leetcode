class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int tar) {
        Arrays.sort(cand);
        List<List<Integer>> list = new ArrayList<>();
        bt(cand,tar,list,new ArrayList<>(),0);
        return list;
    }
    private void bt(int cand[] , int tar , List<List<Integer>> list , List<Integer> lister , int curr){
        if(tar == 0){
            list.add(new ArrayList<>(lister));
            return;
        }
        if(tar < 0){
            return;
        }
        for(int i = curr ; i < cand.length ; i++){
            if(i>curr && cand[i] == cand[i-1])continue;
            lister.add(cand[i]);
            bt(cand,tar-cand[i],list,lister,i+1);
            lister.remove(lister.size()-1);
        }
    }
}