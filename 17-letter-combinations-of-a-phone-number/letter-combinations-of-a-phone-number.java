class Solution {
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        HashMap<Character,String>hm = new HashMap<>();
        if(digits.length() == 0)return list;
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        bt(list,digits,hm,0);
        return list;
    }
    private void bt(List<String> list , String digits , HashMap<Character,String> hm , int curr){
        if(curr == digits.length()){
            list.add(sb.toString());
            return;
        }
        char ch = digits.charAt(curr);
        String st = hm.get(ch);
        for(int i = 0 ; i < st.length() ; i++){
            sb.append(st.charAt(i));
            bt(list,digits,hm,curr+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}