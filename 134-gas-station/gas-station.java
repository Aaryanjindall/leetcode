class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int total = 0;
        int st = 0;
        for(int i = 0 ; i < gas.length ; i++){
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if(tank < 0){
                st = i+1;
                tank = 0;
            }
        }
        if(total < 0){
            return -1;
        }
        return st;
    }
}