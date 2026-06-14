class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        bt(list,n,k,1,new ArrayList<>());
        return list;
    }
    private void bt(List<List<Integer>> list , int n , int k , int cur , List<Integer> lister){
        if(k == 0){
            list.add(new ArrayList<>(lister));
            return;
        }
        for(int i = cur ; i <= n ; i++){
            lister.add(i);
            bt(list,n,k-1,i+1,lister);
            lister.remove(lister.size()-1);
        }

    }
}