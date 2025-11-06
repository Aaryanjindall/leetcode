class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(s,0,list,new ArrayList<>());
        return list;
    }
    private void backtrack(String s , int curr , List<List<String>> list,List<String> res){
        if(curr == s.length()){
            list.add(new ArrayList<>(res));
            return;
        }
        for(int i = curr ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ispalen(s.substring(curr,i+1))){
                res.add(s.substring(curr, i + 1));
                backtrack(s,i+1,list,res);
                res.remove(res.size()-1);
            }
            
        }
        
    }
    private boolean ispalen(String a){
        int l = 0;
        int r = a.length()-1;
        while(l < r){
            if(a.charAt(l) != a.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}