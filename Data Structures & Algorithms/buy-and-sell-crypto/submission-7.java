class Solution {
    public int maxProfit(int[] prices) {
        // two pointers
        // sliding window
        // buy on the cheapest
        // sell when more expensive
        // int max = 0;
        // int l = 0 ; r=1
        // loop while(r<prices.length)
            // if(p[r]<p[l])
                // l=r
                // r=l+1
            // else
                // max = .max(max, current)
        // return max
        int l = 0 , r = 1 , max = 0;
        while(r<prices.length){
            if(prices[r]<prices[l]){
                l=r;
                r=l+1;
            }
            else{
                max = Math.max(max, prices[r]-prices[l]);
                r++;
            }
        }
        return max;
    }
}
