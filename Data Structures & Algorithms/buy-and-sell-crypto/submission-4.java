class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        int sell = 1;
        while(sell<prices.length){
            if(prices[sell]<=prices[buy]){
                buy=sell;
                sell++;
                continue;
            }
            int currentProfit = prices[sell]-prices[buy];
            maxProfit = Math.max(currentProfit, maxProfit);
            sell++;
        }
        return maxProfit;
    }
}
