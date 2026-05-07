class Solution {
    int[] memo;
    int len;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        for(int i = 0 ; i<memo.length ; i++){
            memo[i] = -1;
        }
        len = nums.length;
        return dfs(0, nums);
    }

    int dfs(int i, int[] nums){
        if(i>=len){
            return 0;
        }
        if(memo[i]!=-1){
            return memo[i];
        }
        int skip = dfs(i+1, nums);
        int rob = nums[i] + dfs(i+2, nums);
        memo[i] = Math.max(skip, rob);
        return memo[i];
    }
}
