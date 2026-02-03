class Solution {
    public int maxVowels(String s, int k) {
        int j = 0;
        int vc = 0;
        int max = 0;
        String vowels = "aeiouAEIOU";
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(vowels.indexOf(ch) != -1){
                vc++;
            }

            if(i-j+1 > k){
                char cha = s.charAt(j);
                if(vowels.indexOf(cha) != -1){
                    vc--;
                }
                j++;
            }
            if(i-j+1 == k){
                max = Math.max(max,vc);
            }
        }
        return max;
    }
}