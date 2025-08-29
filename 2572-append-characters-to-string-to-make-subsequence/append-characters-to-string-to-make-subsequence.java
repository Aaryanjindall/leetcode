class Solution {
    public int appendCharacters(String s, String t) {
        int x = 0;
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                x++;
                j++;
            }
            i++;
            
        }
        int len = t.length();
        return len - x;

    }
}