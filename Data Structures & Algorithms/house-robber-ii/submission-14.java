class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(helper(nums, 0, nums.length-1), helper(nums, 1, nums.length));
    }

    int helper(int[] nums, int start, int end){
        int twob = nums[start];
        int oneb = Math.max(twob, nums[start+1]);
        int result;

        for(int i = start+2 ; i<end ; i++){
            result = Math.max(nums[i]+twob , oneb);
            twob = oneb;
            oneb = result;
        }

        return oneb;
    }
}
