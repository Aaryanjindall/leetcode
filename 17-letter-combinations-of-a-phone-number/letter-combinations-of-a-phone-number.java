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
    private void bt(List<String> list ,HashMap<Character,String> hm , String dig , int cur){
        if(cur == dig.length()){
            list.add(new StringBuilder(sb).toString());
            return;
        }
        String str = hm.get(dig.charAt(cur));
        for(int i = 0 ; i < str.length() ; i++){
            sb.append(str.charAt(i));
            bt(list,hm,dig,cur+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}