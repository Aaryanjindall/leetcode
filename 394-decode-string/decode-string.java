class Solution {
    int curr = 0;
    public String decodeString(String s){
        return solve(s);
    }
    private String solve(String s){
        StringBuilder sb = new StringBuilder();
        if(s.charAt(curr) == ']'){
            return sb.toString();
        }
        while(curr < s.length() && s.charAt(curr) != ']'){
            if(Character.isLetter(s.charAt(curr))){
                sb.append(s.charAt(curr));
                curr++;
            }
            else if(Character.isDigit(s.charAt(curr))){
                int count = 0;
                while(curr < s.length() && Character.isDigit(s.charAt(curr))){
                    count = count*10 + (s.charAt(curr)-'0');
                    curr++;
                }
                curr++;
                String temp = solve(s);
                while(count--> 0){
                    sb.append(temp);
                }
            }
        }
        if(curr < s.length() && s.charAt(curr) == ']') {
            curr++;
        }
        return sb.toString();
    } 
}