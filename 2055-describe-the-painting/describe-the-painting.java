class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Long,Long> tm = new TreeMap<>();
        for(int seg[] : segments){
            Long a = (long)seg[0];
            Long b = (long)seg[1];
            Long col = (long)seg[2];
            tm.put(a,tm.getOrDefault(a,0L)+col);
            tm.put(b,tm.getOrDefault(b,0L)-col);
        }
        List<List<Long>> res = new ArrayList<>();
        long sum = 0;
        long prev = 1;
        for(Map.Entry<Long,Long> entry : tm.entrySet()){
            long point = entry.getKey();
            if(sum > 0){
                res.add(Arrays.asList(prev,point,sum));
            }
            sum += entry.getValue();
            prev = point;
        }
        return res;
    }
}