class Solution {
    public int maxProfit(int[] prices) {
        int bb = prices[0];
        int sell = 0;
        for(int i = 1 ; i < prices.length ; i++){
            bb = Math.min(prices[i],bb);
            if(bb < prices[i]){
                sell = Math.max(prices[i]-bb,sell);
            }
        }
        return sell;
    }
}