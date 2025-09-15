class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String words [] = text.split(" ");
        int count = 0;
        for(String word : words){
            if(containsAnyChar(word,brokenLetters)){
                count++;
            }
        }

        return words.length - count;

    }
    private boolean containsAnyChar(String word , String brokenLetters){
        for(char ch : brokenLetters.toCharArray()){
            if(word.indexOf(ch) != -1){
                return true;
            }

        }
        return false;
    }
}