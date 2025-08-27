class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        
        // if(valueOf(s)>Integer.MAX_VALUE){
        //     return Integer.MAX_VALUE;
        // }
        // if(valueOf(s)<Integer.MIN_VALUE){
        //     return Integer.MIN_VALUE;
        // }
        int sign = 1 ;
        int i=0;
        if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        else if(s.charAt(i) == '+'){
            sign = 1;
            i++;
            
        }
        long num = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            num = num*10 + digit;
            if(sign == 1 && num > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(sign == -1 && -num < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
            
            i++;
        }
        
        
        return (int)(sign*num);
    }
}