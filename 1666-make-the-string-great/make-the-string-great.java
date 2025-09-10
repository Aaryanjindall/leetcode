class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            int val = (int) ch;
            int len = sb.length();
            
            // if(Math.abs(int(ch) - int(ch2)) != 32){
            //     sb.append(ch);
            // }
            if((len > 0) && Math.abs(val - sb.charAt(len-1)) == 32){
                sb.deleteCharAt(len-1);
            }
            else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}