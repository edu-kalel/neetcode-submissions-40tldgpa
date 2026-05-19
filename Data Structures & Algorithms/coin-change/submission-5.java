class Solution {
    Map<Integer, Integer> hm;
    public int coinChange(int[] coins, int amount) {
        hm = new HashMap<>();
        int result = dfs(amount, coins);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int dfs(int amount, int[] coins){
        if(amount==0){
            return 0;
        }
        if(hm.containsKey(amount)){
            return hm.get(amount);
        }
        int result = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amount-coin >= 0){
                int res2 = dfs(amount-coin, coins);
                if(res2!=Integer.MAX_VALUE){
                    result = Math.min(result, res2+1);
                }
            }
        }
        hm.put(amount, result);
        return result;
    }
}
