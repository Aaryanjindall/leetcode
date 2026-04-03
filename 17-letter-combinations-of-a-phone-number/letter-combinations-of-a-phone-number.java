class Solution {
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits){
        List<String> list = new ArrayList<>();
        if(digits.length() == 0){
            return list;
        }
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        bt(list,hm,digits,0,new StringBuilder());
        return list;
    }
    private void bt(List<String> list, HashMap<Character,String> hm, String digits,int curr , StringBuilder sb){
        if(curr == digits.length()){
            list.add(sb.toString());
            return;
        }
        String res = hm.get(digits.charAt(curr));
        for(int i = 0 ; i < res.length() ; i++){
            sb.append(res.charAt(i));
            bt(list,hm,digits,curr+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}