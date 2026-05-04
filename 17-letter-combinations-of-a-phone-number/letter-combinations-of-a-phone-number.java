class Solution {
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        
        List<String> list = new ArrayList<>();
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        bt(list,hm,digits,0);
        return list;
    }
    private void bt(List<String> list ,HashMap<Character,String> hm,String dig , int curr){
        if(curr == dig.length()){
            list.add(new StringBuilder(sb).toString());
            return;
        }
        
        char ch = dig.charAt(curr);
        String str = hm.get(ch);
        for(int i = 0 ; i < str.length() ; i++){
            sb.append(str.charAt(i));
            bt(list,hm,dig,curr+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}
