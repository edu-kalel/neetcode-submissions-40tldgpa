class Solution {
    public int findMin(int[] nums) {
        // binary search
        // int l = 0 , r = nums.length , mid  = mid, min = int.max_value
        // loop
        // while(n[l]>n[r])
            // min = min(min, n[mid])
            // if(m[mid]>=n[l])
                // search right
                // l = mid+1
                // new mid
            // else
                // r = mid-1 ??? awas checale bn ahí
                // new mid
        // min = min(min, n[l])
        int l = 0 , r = nums.length-1 , mid = nums.length / 2 , min = Integer.MAX_VALUE;
        while(nums[l]>nums[r]){
            min = Math.min(min, nums[mid]);
            if(nums[mid]>=nums[l]){
                l = mid+1;
                mid = ((r-l)/2)+l;
            }
            else{
                r = mid-1;
                mid = ((r-l)/2)+l;
            }
        }
        return Math.min(min, nums[l]);
    }
}
