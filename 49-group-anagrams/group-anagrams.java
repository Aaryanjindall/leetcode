class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String,List<String>> hm = new HashMap<>();
        for(String st : strs){
            char[] temper = st.toCharArray();
            Arrays.sort(temper);
            String temp = new String(temper);
            if(!hm.containsKey(temp)){
                hm.put(temp,new ArrayList<>());
            }
            hm.get(temp).add(st);
        }
        for(List<String> val : hm.values()){
            list.add(val);
        }
        return list;
    }
}