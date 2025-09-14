class Solution {
    public int maxProfit(int[] prices) {
        int bestbuy = prices[0];
        int maxprofit = 0;
        for(int i = 1 ; i < prices.length ; i++){
            bestbuy = Math.min(bestbuy,prices[i]);
            if(bestbuy < prices[i]){
                maxprofit = Math.max(maxprofit , prices[i] - bestbuy);
            }
        }
        return maxprofit;
    }
}