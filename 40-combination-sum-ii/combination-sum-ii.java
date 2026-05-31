class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int tar) {
        Arrays.sort(cand);
        List<List<Integer>> list = new ArrayList<>();
        bt(cand,tar,list,0,new ArrayList<>());
        return list;
    }
    private void bt(int cand[] , int tar , List<List<Integer>> list , int cur , List<Integer> lister){
        if(tar == 0){
            list.add(new ArrayList<>(lister));
            return;
        }
        if(tar < 0){
            return;
        }
        for(int i = cur ; i < cand.length ; i++){
            if(i > cur && cand[i] == cand[i-1]){
                continue;
            }
            lister.add(cand[i]);
            bt(cand,tar-cand[i],list,i+1,lister);
            lister.remove(lister.size()-1);
        }
    }
}