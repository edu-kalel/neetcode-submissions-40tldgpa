class Solution {
    public int rob(int[] nums) {
        // base cases
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }

        // two cases
        // rob first (cant rob last)
        int case1 = helper(nums, 0, nums.length-1);
        int case2 = helper(nums, 1, nums.length);

        return Math.max(case1, case2);
    }

    int helper(int[] nums, int start, int end){
        int twob = nums[start];
        int oneb = Math.max(nums[start+1], twob);
        for(int i = start+2; i<end ; i++){
            int temp = Math.max(oneb, twob + nums[i]);
            twob = oneb;
            oneb = temp;
        }
        return oneb;
    }
}