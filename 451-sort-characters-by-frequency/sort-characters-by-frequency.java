class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray()){
            hm.put(ch , hm.getOrDefault(ch , 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> hm.get(b) - hm.get(a));
        for(char cha : hm.keySet()){
            pq.add(cha);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.remove();
            int freq = hm.get(ch);
            for(int i = 0 ; i < freq ; i++){
                sb.append(ch);
            }
            
        }
        return sb.toString();

    }
}