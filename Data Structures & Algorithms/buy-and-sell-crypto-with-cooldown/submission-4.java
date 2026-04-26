class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;

        int buy = -prices[0];
        int sold = 0, rest = 0;

        for(int i = 1; i < prices.length; i++){
            int prevBuy = buy;
            int prevSold = sold;
            int prevRest = rest;

            buy = Math.max(prevBuy, prevRest - prices[i]);
            sold = prevBuy + prices[i];
            rest = Math.max(prevRest, prevSold);
        }
        return Math.max(sold, rest);
    }
}
