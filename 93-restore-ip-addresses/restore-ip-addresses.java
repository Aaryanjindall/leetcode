class Solution {
    StringBuilder sb = new StringBuilder();
    
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        bt(list,s,0,0);
        return list;
    }
    private void bt(List<String> list , String s , int curr,int parts){
        if(parts == 4 && curr == s.length()){
            list.add(sb.toString());
            return;
        }
        if(parts == 4 || curr == s.length()){
            return;
        }
        if(parts > 4){
            return;
        }
        for(int len = 1 ; len <= 3&& curr + len <= s.length() ; len++){
            String part = s.substring(curr,curr+len);
            if(isvalid(part)){
                int oldlen = sb.length();
                // sb.append(part);
                // sb.append(".");
                // int oldlen = part.length();
                if(parts > 0)sb.append(".");
                sb.append(part);
                bt(list,s,curr+len,parts+1);
                sb.setLength(oldlen);
            }
        }
    }
    private boolean isvalid(String str){
        int len = str.length();
        if(len == 0 || len > 3)return false;
        if(len == 2 || len == 3){
            if(str.charAt(0) == '0'){
                return false;
            }
            int par = Integer.parseInt(str);
            if(par < 0 || par > 255){
                return false;
            }
        }
        return true;
    }
}