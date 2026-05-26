class Solution {
    public int maxVowels(String s, int k) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = s.length();
        int vowels = 0;
        String vowel = "aeiou";
        int j = 0;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
            if(vowel.indexOf(ch) != -1){
                vowels++;
            }
            while(i-j+1 == k){
                max = Math.max(max,vowels);
                char cha = s.charAt(j);
                hm.put(cha,hm.get(cha)-1);
                if(vowel.indexOf(cha) != -1){
                    vowels--;
                }
                j++;
            }
        }
        return max;
    }
}