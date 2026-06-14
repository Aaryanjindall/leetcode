class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        bt(list,k,n,1,new ArrayList<>());
        return list;
    }
    private void bt(List<List<Integer>> list , int k , int n ,int cur, List<Integer> lister){
        if(k == 0){
            if(n == 0){
                list.add(new ArrayList<>(lister));
                return;
            }
        }
        if(n<0){
            return;
        }
        for(int i = cur ; i <= 9 ; i++){
            lister.add(i);
            bt(list,k-1,n-i,i+1,lister);
            lister.remove(lister.size()-1);
        }       
    }
}