class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int cos = 0;
        if(cost.length < 3){
            for(int i : cost){
                cos += i;
            }
            return cos;
        }
        int i = cost.length-1;
        while(i >= 0){
            cos += cost[i];
            if(i-1 >= 0){
                cos += cost[i-1];
            }
            // if(i>=0){
                i -= 3;
            // }
        }
        return cos;
    }
}