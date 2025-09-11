class Solution {
    public String sortVowels(String s) {
        char charArray[] = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        ArrayList<Character> list = new ArrayList<>();

        for(char ch : charArray){
            if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'){
                list.add(ch);
            }

        }

        Collections.sort(list);
        int index = 0;
        for(char ch : charArray){
            if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'){
                ch = list.get(index);
                index++;
            }
            sb.append(ch);
        }


        return sb.toString();

        
    }
}