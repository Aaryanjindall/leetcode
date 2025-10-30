class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        List<String> list = new ArrayList<>();
        backtrack(list,hm,0,digits,new StringBuilder());
        return list;
    }
    private void backtrack(List<String> list , HashMap<Character,String> hm , int curr , String digits , StringBuilder sb){
        if(curr == digits.length()){
            list.add(sb.toString());
            return;
        }
        char ch = digits.charAt(curr);
        String st = hm.get(ch);
        for(int i = 0 ; i < st.length() ; i++){
            sb.append(st.charAt(i));
            backtrack(list,hm,curr+1,digits,sb);
            sb.deleteCharAt(sb.length()-1); //bacltrack

        }
    }
}