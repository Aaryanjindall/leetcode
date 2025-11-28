class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int creams = 0;
        for(int i = 0 ; i < costs.length ; i++){
            if(coins < costs[i]){
                break;
            }
            
                coins -= costs[i];
                creams++;
            
        }
        return creams;
    }
}