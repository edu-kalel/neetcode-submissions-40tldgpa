class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int buy = 0;
        int sell =1;
        while(sell<prices.length){
            if(prices[sell]<=prices[buy]){
                buy=sell;
                sell=buy+1;
                continue;
            }
            else{
                result = Math.max(result, prices[sell]-prices[buy]);
                sell++;
            }
        }
        return result;
    }
}
