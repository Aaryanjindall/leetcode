class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int tar) {
        List<List<Integer>> list = new ArrayList<>();
        bt(list,cand,tar,0,new ArrayList<>());
        return list;
    }
    private void bt(List<List<Integer>> list , int cand[] , int tar , int curr,List<Integer> res){
        if(tar == 0){
            list.add(new ArrayList<>(res));
            return;
        }
        if(tar < 0) return;
        for(int i = curr ; i < cand.length ; i++){
            res.add(cand[i]);
            bt(list,cand,tar-cand[i],i,res);
            res.remove(res.size()-1);
        }
    }

//curr hm isiliye use karte h loop m kyunki agr hm 0 se n tak krenge toh hmare pass sirf ek iteration hui lekin hmme chiye curr times iteration toh hm curr se start karte h kyunki curr pehle 0 hoga fir 0 se n fir kar hoga 1 fir 1 se n fir aise hi chalta rahgea n times iteration ke liye 
}