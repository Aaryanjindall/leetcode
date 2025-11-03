class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder("");
        dfs(s,0,sb);
        return sb.toString();
    }
    public void dfs(String s , int curr , StringBuilder sb){
        if(curr == s.length()){
            return;
        }
        if((sb.length() == 0) || (sb.charAt(sb.length()-1)!=s.charAt(curr))){
            sb.append(s.charAt(curr));
        }
        else if(sb.charAt(sb.length()-1) == s.charAt(curr)){
            sb.deleteCharAt(sb.length()-1);
        }
        dfs(s,curr+1,sb);
    
    }
}