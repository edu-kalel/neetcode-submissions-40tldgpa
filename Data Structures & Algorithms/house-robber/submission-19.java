class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        // int[] dp = new int[nums.length];
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);
        int twob = nums[0];
        int oneb = Math.max(nums[0], nums[1]);
        int result;

        int i;
        for(i = 2 ; i<nums.length ; i++){
            result = Math.max(oneb, nums[i]+twob);
            twob = oneb;
            oneb = result;
        }

        return oneb;
    }
}
