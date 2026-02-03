class Solution {
    public String reverseVowels(String s) {
        char str [] = s.toCharArray();
        int i = 0;
        int j = str.length - 1;
        while(i<j){
            if(check(str[i])){
                if(check(str[j])){
                    swap(str,i,j);
                    i++;
                    j--;
                }
            }
            if(!check(str[i])){
                i++;
            }
            if(!check(str[j])){
                j--;
            }
            
        }
        return new String(str);
    }
    private boolean check(char ch){
        String vowels = "AEIOUaeiou";
        return vowels.indexOf(ch) != -1;
    }
    private void swap(char [] ch , int i , int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}