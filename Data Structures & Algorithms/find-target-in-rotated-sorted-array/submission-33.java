class Solution {
    public int search(int[] nums, int target) {
        // 
        int l = 0 , r = nums.length-1, mid;
        while(l<=r){
            mid = ((r-l)/2)+l;
            if(nums[mid]==target){
                return mid;
            }
            // we are in the left
            if(nums[l]<=nums[mid]){
                if(target>nums[mid] || target<nums[l]){
                    // go right??
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
            else{
                // we on the right
                if(target<nums[mid] || target > nums[r]){
                    // go left
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
        }
        return -1;
    }
}
