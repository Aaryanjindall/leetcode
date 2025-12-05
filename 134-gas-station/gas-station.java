class Solution {
    public int canCompleteCircuit(int[] g, int[] c) {
        int index = 0;
        int gsum = 0;
        int csum = 0;
        int tank = 0;
        int start = 0;
        for(int i = start ; i < g.length ; i++){
            gsum += g[i];
            csum += c[i];
        }
        if(gsum < csum){
            return -1;
        }
        for(int i = 0 ; i < g.length ; i++){
            tank += g[i]-c[i];
            if(tank < 0){
                start = i+1;
                tank = 0;
            }

        }
        return start;
    }
    
}