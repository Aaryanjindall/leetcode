class Solution {
    public boolean isNStraightHand(int[] hd, int gs){
        if(hd.length % gs != 0){
            return false;
        }
        int groups = hd.length/gs;
        int gcount = 0;
        Arrays.sort(hd);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < hd.length ; i++){
            hm.put(hd[i],hm.getOrDefault(hd[i],0)+1);
        }
        for(int i = 0 ; i < hd.length ; i++){
            if(!hm.containsKey(hd[i]))continue;
            for(int j = 0 ; j < gs ; j++){
                int curr = hd[i]+j;
                if(!hm.containsKey(curr)){
                    return false;
                }
                hm.put(curr,hm.get(curr)-1);
                if(hm.get(curr) == 0){
                    hm.remove(curr);
                }
            }
        }
        return true;
    }
}