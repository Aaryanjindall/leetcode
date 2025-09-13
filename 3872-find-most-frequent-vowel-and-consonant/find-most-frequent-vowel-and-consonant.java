class Solution {
    public int maxFreqSum(String s) {
        int freq [] = new int [26];
        int freq2 [] = new int [26];
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(isvowel(ch)){
                freq[ch - 'a']++;
            }
            else{
                freq2[ch - 'a']++;
            }
        }
        int maxvowel = 0;
        int maxconso = 0;
        for(int i = 0 ; i < 26 ; i++){
            maxvowel = Math.max(maxvowel , freq[i]);
            maxconso = Math.max(maxconso , freq2[i]);
        }

        return maxvowel + maxconso;


    }
    private boolean isvowel(Character ch){
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}