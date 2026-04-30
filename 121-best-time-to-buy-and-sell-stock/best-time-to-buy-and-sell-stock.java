class Solution {
    public int maxProfit(int[] prices){
        int bb = prices[0];
        int max = 0;
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i]<bb){
                bb = prices[i];
            }
            max = Math.max(max,prices[i]-bb); 
        }
        return max;
    }
}