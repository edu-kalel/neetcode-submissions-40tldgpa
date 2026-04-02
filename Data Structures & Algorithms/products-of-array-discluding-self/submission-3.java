class Solution {
    public int[] productExceptSelf(int[] nums) {
        // two passes
        // prefix & postfix
        // int prefix = 1 
        // looop
            // res[i] = prefix
            // prefix *= nums[i]
        // rinse repeat
        // now post
        // post = 1
        // d atras pa delante
        // i = last of array
            // res[i] *= postfix
            // postfix *= nums[i]
        //
        int nlen = nums.length;
        int prefix = 1;
        int[] res = new int[nlen];
        for(int i = 0 ; i<nlen ; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }
        // now post
        int post = 1;
        for(int i = nlen-1 ; i>=0 ; i--){
            res[i] *= post;
            post *= nums[i];
        }
        return res;
    }
}  
