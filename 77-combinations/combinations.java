class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(n,k,1,list,new ArrayList<>());
        return list;
    }
    private void backtrack(int n , int k ,int idx, List<List<Integer>> list,List<Integer> temp){
        if(k == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx ; i <= n ; i++){
            temp.add(i);
            backtrack(n,k-1,i+1,list,temp);
            temp.remove(temp.size()-1);
        }

    }
}