class Solution {
    List<String> lister = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        bt(list,s,0);
        return list;
    }
    private void bt(List<List<String>> list , String s , int curr){
        if(curr == s.length()){
            list.add(new ArrayList<>(lister));
            return;
        }
        for(int i = curr ; i < s.length() ; i++){
            if(check(s.substring(curr,i+1))){
                lister.add(s.substring(curr,i+1));
                bt(list,s,i+1);
                lister.remove(lister.size()-1);
            }
        }
    }
    private boolean check(String a){
        int i = 0;
        int j = a.length()-1;
        while(i<j){
            if(a.charAt(i)!=a.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}