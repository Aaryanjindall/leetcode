class Solution {
    public int[] vowelStrings(String[] words, int[][] queries){
        int n = queries.length;
        int m = words.length;
        int ans[] = new int[n];
        int idx = 0;
        int prefix[] = new int[m+1];
        for(int i = 0 ; i < m ; i++){
            prefix[i+1] = prefix[i];
            if(check(words[i])){
                prefix[i+1]++;
            }
        }
        for(int q[] : queries){
            int a = q[0];
            int b = q[1];
            ans[idx] = prefix[b+1]-prefix[a];
            idx++;
        }
        return ans;
    }
    private boolean check(String word){
        String vowel = "aeiou";
        return (vowel.indexOf(word.charAt(0)) != -1) && (vowel.indexOf(word.charAt(word.length()-1)) != -1);
    }
}