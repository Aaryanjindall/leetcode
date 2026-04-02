class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int tar) {
        Arrays.sort(cand);
        List<List<Integer>> list = new ArrayList<>();
        bt(list, cand, tar, 0, new ArrayList<>());
        return list;
    }

    private void bt(List<List<Integer>> list , int cand[] , int tar , int curr, List<Integer> res){

        if(tar == 0){
            list.add(new ArrayList<>(res));
            return;
        }

        for(int i = curr ; i < cand.length ; i++){

            // 🔥 skip duplicates
            if(i > curr && cand[i] == cand[i-1]) continue;

            if(cand[i] > tar) break; // optimization

            res.add(cand[i]);
            bt(list, cand, tar - cand[i], i + 1, res); // no reuse
            res.remove(res.size() - 1);
        }
    }
}