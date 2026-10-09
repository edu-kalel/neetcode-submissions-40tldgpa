class Solution {
    public boolean canJump(int[] nums) {
        // boolean[] dp = new boolean[nums.length];
        int target = nums.length-1;
        // dp[dp.length-1] = true;
        for(int i = nums.length - 2 ; i>= 0 ; i--){
            if(i + nums[i] >= target){
                // dp[i] = dp[target];
                target = i;
            }
        }
        return target==0;
    }
}
