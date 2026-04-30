class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String,List<String>> hm = new HashMap<>();
        for(String s : strs){
            String temp = s;
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            s = new String(arr);
            hm.putIfAbsent(s, new ArrayList<>());
            hm.get(s).add(temp);
        }
        return new ArrayList<>(hm.values());
    }
}