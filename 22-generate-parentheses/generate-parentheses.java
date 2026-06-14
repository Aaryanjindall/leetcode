class Solution {
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int open = 0;
        int close = 0;
        bt(list,0,0,n);
        return list;
    }
    private void bt(List<String> list , int op , int close , int n){
        if(sb.length() == 2*n){
            list.add(new StringBuilder(sb).toString());
            return;
        }
        if(op < n){
            sb.append('(');
            bt(list,op+1,close,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < op){
            sb.append(')');
            bt(list,op,close+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}