class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        bt(list,s,0,new ArrayList<>());
        return list;
    }
    private void bt(List<List<String>> list , String s , int curr , List<String> lister){
        if(curr == s.length()){
            list.add(new ArrayList<>(lister));
            return;
        }
        for(int i = curr ; i < s.length() ; i++){
            if(check(s.substring(curr,i+1))){
                lister.add(s.substring(curr,i+1));
                bt(list,s,i+1,lister);
                lister.remove(lister.size()-1);
            }
        }
    }
    private boolean check(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}