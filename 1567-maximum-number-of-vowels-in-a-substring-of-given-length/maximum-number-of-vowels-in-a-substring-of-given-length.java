class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        String vowels = "aeiou";
        int max = 0;
        int vc = 0;
        int j = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(vowels.indexOf(ch) != -1){
                vc++;
            }
            while(i-j+1 > k){
                char cha = s.charAt(j);
                if(vowels.indexOf(cha) != -1){
                    vc--;
                }
                j++;
            }
            if(i-j+1 == k){
                max = Math.max(vc,max);
            }
        }
        return max;
    }
}