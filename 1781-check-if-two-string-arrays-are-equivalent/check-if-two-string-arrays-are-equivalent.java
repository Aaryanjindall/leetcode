class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for(String ch : word1){
            sb.append(ch);
        }
        StringBuilder sb2 = new StringBuilder();
        for(String cha : word2){
            sb2.append(cha);
        }

        return sb.toString().equals(sb2.toString());

    }
}