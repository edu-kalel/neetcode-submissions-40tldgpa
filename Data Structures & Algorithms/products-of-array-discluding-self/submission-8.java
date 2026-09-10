class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pre = 1;
        int nlen = nums.length;
        for(int i = 0 ; i<res.length ; i++){
            res[i] = pre;
            pre *= nums[i];
        }

        int post = 1;
        for(int i = res.length-1 ; i>=0 ; i--){
            res[i] *= post;
            post *= nums[i];
        }

        return res;
    }
}  
