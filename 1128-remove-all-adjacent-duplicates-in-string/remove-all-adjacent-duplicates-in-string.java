class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        solve(s,0,sb);
        return sb.toString();
    }
    private void solve(String s,int curr , StringBuilder sb){
        if(curr == s.length()){
            return;
        }
        if(sb.length() == 0){
            sb.append(s.charAt(curr));
            solve(s,curr+1,sb);
        }
        else if(sb.length() > 0 && sb.charAt(sb.length()-1) != s.charAt(curr)){
            sb.append(s.charAt(curr));
            solve(s,curr+1,sb);
        }
        else if(sb.length() > 0 && sb.charAt(sb.length()-1) == s.charAt(curr)){
            sb.deleteCharAt(sb.length()-1);
            solve(s,curr+1,sb);
        }
    }
}