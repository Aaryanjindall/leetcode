class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        bt(list,n,k,1,new ArrayList<>());
        return list;
    }
    private void bt(List<List<Integer>> list , int n , int k , int curr , List<Integer> res){
        if(res.size()==k){
            list.add(new ArrayList<>(res));
            return;
        }
        for(int i = curr ; i <= n ; i++){
            res.add(i);
            bt(list,n,k,i+1,res);
            res.remove(res.size()-1);
        }
    }
}