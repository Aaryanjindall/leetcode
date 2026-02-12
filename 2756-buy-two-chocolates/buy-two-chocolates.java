class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int price = prices[0]+prices[1];
        int left = money - price;
        if(left >= 0){
            return left;
        }
        
        return money;
        // 
        // for(int i = 0 ; i < prices.length ; i++){
        //     // while()
        //     money -= prices[i];
        //     sum += prices[i];
        // }
    }
}