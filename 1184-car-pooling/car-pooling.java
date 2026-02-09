class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int [] trip : trips){
            int pass = trip[0];
            int from  = trip[1];
            int to = trip[2];
            tm.put(from, tm.getOrDefault(from, 0) + pass);
            tm.put(to, tm.getOrDefault(to, 0) - pass);
        }
        int over = 0;
        for(int del : tm.values()){
            over += del;
            if(over > capacity){
                return false;
            }
        }
        return true;
    }
}