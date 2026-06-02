class Solution {
    public int numOfSubarrays(int[] arr) {
        int mode = 1000000007;
        int prefix = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        long sub = 0;
        int mod = 0;
        for(int i = 0 ; i < arr.length ; i++){
            prefix += arr[i];
            mod = prefix%2;
            if(mod == 0){
                sub += hm.getOrDefault(1,0);
            }
            else{
                sub += hm.getOrDefault(0,0);
            }
            hm.put(mod,hm.getOrDefault(mod,0)+1);
        }
        return (int)(sub%mode);
    }
}